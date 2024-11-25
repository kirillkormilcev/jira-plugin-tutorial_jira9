package ru.teamlead.jira.plugins.tutorial.action;

import com.atlassian.jira.issue.tabpanels.GenericMessageAction;
import com.atlassian.jira.plugin.issuetabpanel.AbstractIssueTabPanel3;
import com.atlassian.jira.plugin.issuetabpanel.GetActionsRequest;
import com.atlassian.jira.plugin.issuetabpanel.IssueAction;
import com.atlassian.jira.plugin.issuetabpanel.ShowPanelRequest;
import com.atlassian.velocity.VelocityManager;
import java.util.Collections;
import java.util.List;
import ru.teamlead.jira.plugins.tutorial.listener.TutorialUtils;

public class IssueTabWithWebPanel extends AbstractIssueTabPanel3 {
  private final VelocityManager velocityManager;
  private final TutorialUtils tutorialUtils;

  public IssueTabWithWebPanel(
      VelocityManager velocityManager,
      TutorialUtils tutorialUtils
  ) {
    this.velocityManager = velocityManager;
    this.tutorialUtils = tutorialUtils;
  }
  @Override
  public boolean showPanel(ShowPanelRequest showPanelRequest) {
    return true;
  }

  @Override
  public List<IssueAction> getActions(GetActionsRequest getActionsRequest) {

    String renderedHtml = velocityManager.getEncodedBody(
        "templates/tutorial/webpanel/",
        "webpanel-example.vm",
        tutorialUtils.getBaseUrl(),
        tutorialUtils.getWebworkEncoding(),
        tutorialUtils.getVelocityContext());

    return Collections.singletonList(new GenericMessageAction(renderedHtml));
  }
}
