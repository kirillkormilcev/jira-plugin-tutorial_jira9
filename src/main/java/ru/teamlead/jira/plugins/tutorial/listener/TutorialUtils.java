package ru.teamlead.jira.plugins.tutorial.listener;

import com.atlassian.activeobjects.external.ActiveObjects;
import com.atlassian.jira.issue.Issue;
import com.atlassian.jira.permission.GlobalPermissionKey;

import java.util.List;
import java.util.Map;

/**
 * @author V.Nikolaev
 * @version $Revision$
 */
//логики нет
public interface TutorialUtils {
    Boolean getNeededPermissions();

    List<Issue> getIssues(String jql);

    List<IssueVO> getIssuesVo(String jql);

    void initEntities();

    Map<String, String> getMapOfEntities();

    String getBaseUrl();

    String getWebworkEncoding();

    Map<String, Object> getVelocityContext();
}