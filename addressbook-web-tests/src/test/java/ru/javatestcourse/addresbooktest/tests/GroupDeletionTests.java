package ru.javatestcourse.addresbooktest.tests;

import org.testng.annotations.*;

public class GroupDeletionTests extends TestBase {
  @Test
  public void testGroupDeletion() throws Exception {
    app.gotoGroupsList();
    app.selectGroupByOrder("1");
    app.clickDeleteGroup();
    app.returnToGroupsPage();

  }

}