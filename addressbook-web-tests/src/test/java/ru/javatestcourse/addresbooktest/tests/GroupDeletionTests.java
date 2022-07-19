package ru.javatestcourse.addresbooktest.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.javatestcourse.addresbooktest.models.GroupObject;

public class GroupDeletionTests extends TestBase {
  @Test
  public void testGroupDeletion() throws Exception {
    app.getNavigationHelper().gotoGroupsList();
    if (! app.getGroupHelper().doesSomeGroupExists())
    {
      app.getGroupHelper().createGroup(new GroupObject("test1", null, null));
    }
    int before = app.getGroupHelper().getGroupCount();
    app.getGroupHelper().selectGroupByOrder(1);
    app.getGroupHelper().clickDeleteGroup();
    app.getGroupHelper().returnToGroupsPage();
    int after = app.getGroupHelper().getGroupCount();
    Assert.assertEquals(after, before - 1);
  }

}