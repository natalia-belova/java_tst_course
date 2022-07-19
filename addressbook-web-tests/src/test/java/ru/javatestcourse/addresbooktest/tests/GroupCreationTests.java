package ru.javatestcourse.addresbooktest.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.javatestcourse.addresbooktest.models.GroupObject;

import java.util.HashSet;
import java.util.List;


public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreation() throws Exception {
        app.getNavigationHelper().gotoGroupsList();
        List<GroupObject> before = app.getGroupHelper().getGroupList();
        GroupObject group = new GroupObject("test1", "test2", "test3");
        app.getGroupHelper().createGroup(group);
        List<GroupObject> after = app.getGroupHelper().getGroupList();
        Assert.assertEquals(after.size(), before.size() + 1);
//        int max1 = 0;
//        for (GroupObject g : after) {
//            if (g.getId() > max1) {
//                max1 = g.getId();
//            }
//        }
//        int max = after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId();
        //        делаем из списков множества и сравниваем
        group.setId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());
        before.add(group);
        Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
    }

}
