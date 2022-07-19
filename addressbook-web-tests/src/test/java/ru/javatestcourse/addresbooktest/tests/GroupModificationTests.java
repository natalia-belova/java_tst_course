package ru.javatestcourse.addresbooktest.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.javatestcourse.addresbooktest.models.ContactObject;
import ru.javatestcourse.addresbooktest.models.GroupObject;

import java.util.HashSet;
import java.util.List;

public class GroupModificationTests extends TestBase {
    @Test
    public void testGroupModification() throws Exception {
        app.getNavigationHelper().gotoGroupsList();
        if (!app.getGroupHelper().doesSomeGroupExists()) {
            app.getGroupHelper().createGroup(new GroupObject("test1", null, null));
        }
        List<GroupObject> before = app.getGroupHelper().getGroupList();
        app.getGroupHelper().selectGroupByOrder(before.size() - 1);
        app.getGroupHelper().clickEditGroup();
        GroupObject group = new GroupObject(before.get(before.size() - 1).getId(), "test1UPD", "test2UPD", "test3UPD");
        app.getGroupHelper().enterGroupFormValues(group);
        app.getGroupHelper().updateGroupForm();
        app.getGroupHelper().returnToGroupsPage();
        List<GroupObject> after = app.getGroupHelper().getGroupList();
        Assert.assertEquals(after.size(), before.size());
        before.remove(before.size() - 1);
        before.add(group);
//        делаем из списков множества и сравниваем
        Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
    }
}
