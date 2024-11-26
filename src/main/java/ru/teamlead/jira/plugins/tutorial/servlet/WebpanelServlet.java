package ru.teamlead.jira.plugins.tutorial.servlet;

import com.atlassian.activeobjects.external.ActiveObjects;
import java.io.IOException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import ru.teamlead.jira.plugins.tutorial.ao.ExampleEntity;

/**
 * @deprecated
 */
@Deprecated
public class WebpanelServlet extends HttpServlet {
  private static final Logger log = Logger.getLogger(WebpanelServlet.class);

  private final ActiveObjects ao;

  public WebpanelServlet(ActiveObjects ao) {
    this.ao = ao;
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) {

    String currentUrl = "";
    Object urlObject = request.getAttribute("sanitized.referer");
    if (urlObject instanceof String)
      currentUrl = (String) urlObject;

    String res = ao.executeInTransaction(() -> {

      ExampleEntity entity = ao.create(ExampleEntity.class);
      entity.setName(request.getParameter("name"));
      entity.setLink(request.getParameter("link"));
      entity.save();
      return "true";
    });

    try {
      if (res.equals("true")) {
        response.sendRedirect(currentUrl);
      } else {
        log.error(res);
        response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
      }
    } catch (IOException e) {
      log.error(e.getMessage());
    }
  }
}
