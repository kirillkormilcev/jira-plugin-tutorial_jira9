package ru.teamlead.jira.plugins.tutorial.ao;

import net.java.ao.Entity;
import net.java.ao.schema.StringLength;

public interface ExampleEntity extends Entity {

  String getName();
  void setName(String name);

  @StringLength(StringLength.UNLIMITED)
  String getLink();
  void setLink(String link);
}
