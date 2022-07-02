package ru.javatestcourse.addresbooktest.tests;

import org.testng.annotations.Test;
import ru.javatestcourse.addresbooktest.models.ContactObject;
import ru.javatestcourse.addresbooktest.models.GroupObject;

public class GroupModificationTests extends TestBase {
    @Test
    public void testGroupModification() throws Exception {
        app.getNavigationHelper().gotoGroupsList();
        app.getGroupHelper().selectGroupByOrder("1");
        app.getGroupHelper().clickEditGroup();
        app.getGroupHelper().enterGroupFormValues(new GroupObject("test1UPD", "test2UPD", "test3UPD"));
        app.getGroupHelper().updateGroupForm();
        app.getGroupHelper().returnToGroupsPage();
    }
}
