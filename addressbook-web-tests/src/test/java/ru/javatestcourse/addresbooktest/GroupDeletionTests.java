package ru.javatestcourse.addresbooktest;

import org.testng.annotations.*;

public class GroupDeletionTests extends TestBase {
  @Test
  public void testGroupDeletion() throws Exception {
    gotoGroupsList();
    selectGroupByOrder("1");
    clickDeleteGroup();
    gotoGroupsPage();

  }

}