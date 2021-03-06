package ru.javatestcourse.addresbooktest.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.javatestcourse.addresbooktest.models.GroupObject;

import java.util.List;

public class GroupDeletionTests extends TestBase {
  @Test
  public void testGroupDeletion() throws Exception {
    app.getNavigationHelper().gotoGroupsList();
    if (! app.getGroupHelper().doesSomeGroupExists())
    {
      app.getGroupHelper().createGroup(new GroupObject("test1", null, null));
    }
    List<GroupObject> before = app.getGroupHelper().getGroupList();
    app.getGroupHelper().selectGroupByOrder(before.size() - 1);
    app.getGroupHelper().clickDeleteGroup();
    app.getGroupHelper().returnToGroupsPage();
    List<GroupObject> after = app.getGroupHelper().getGroupList();
    Assert.assertEquals(after.size(), before.size() - 1);
//    removing last element - and last element was checked for deletion in previous steps
    before.remove(before.size() - 1);
    Assert.assertEquals(before, after);
  }

}