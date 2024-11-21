package ru.teamlead.jira.plugins.tutorial.action;

import com.atlassian.jira.config.properties.APKeys;
import com.atlassian.jira.config.properties.ApplicationProperties;
import com.atlassian.jira.issue.tabpanels.GenericMessageAction;
import com.atlassian.jira.plugin.issuetabpanel.AbstractIssueTabPanel3;
import com.atlassian.jira.plugin.issuetabpanel.GetActionsRequest;
import com.atlassian.jira.plugin.issuetabpanel.IssueAction;
import com.atlassian.jira.plugin.issuetabpanel.ShowPanelRequest;
import com.atlassian.jira.util.VelocityParamFactory;
import com.atlassian.velocity.VelocityManager;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import ru.teamlead.jira.plugins.tutorial.listener.TutorialUtils;

public class IssueTabExample extends AbstractIssueTabPanel3 {

  private final ApplicationProperties applicationProperties;
  private final VelocityManager velocityManager;
  private final VelocityParamFactory velocityParamFactory;
  private final TutorialUtils tutorialUtils;

  public IssueTabExample(
      ApplicationProperties applicationProperties,
      VelocityManager velocityManager,
      VelocityParamFactory velocityParamFactory,
      TutorialUtils tutorialUtils
  ) {
    this.applicationProperties = applicationProperties;
    this.velocityManager = velocityManager;
    this.velocityParamFactory = velocityParamFactory;
    this.tutorialUtils = tutorialUtils;
  }

  @Override
  public boolean showPanel(ShowPanelRequest showPanelRequest) {
    return true;
  }

  @Override
  public List<IssueAction> getActions(GetActionsRequest getActionsRequest) {

    String baseUrl = applicationProperties.getString(APKeys.JIRA_BASEURL);
    String webworkEncoding = applicationProperties.getString(APKeys.JIRA_WEBWORK_ENCODING);

    Map<String, Object> context = velocityParamFactory.getDefaultVelocityParams();

    tutorialUtils.initEntities();
    Map<String, String> drops = tutorialUtils.getMapOfEntities();

    context.put("drops", drops);

    String renderedHtml = velocityManager.getEncodedBody("templates/tutorial/dropdown/",
        "dropdown-example.vm", baseUrl, webworkEncoding, context);

    return Collections.singletonList(new GenericMessageAction(renderedHtml));
  }
}
