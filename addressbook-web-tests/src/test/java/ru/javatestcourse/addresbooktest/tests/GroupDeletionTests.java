package ru.javatestcourse.addresbooktest.tests;

import org.testng.annotations.*;

public class GroupDeletionTests extends TestBase {
  @Test
  public void testGroupDeletion() throws Exception {
    app.gotoGroupsList();
    app.getGroupHelper().selectGroupByOrder("1");
    app.getGroupHelper().clickDeleteGroup();
    app.getGroupHelper().returnToGroupsPage();

  }

}