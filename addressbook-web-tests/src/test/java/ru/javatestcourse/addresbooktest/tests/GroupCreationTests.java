package ru.javatestcourse.addresbooktest.tests;

import org.testng.annotations.*;
import ru.javatestcourse.addresbooktest.models.GroupObject;

public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreation() throws Exception {
        app.getNavigationHelper().gotoGroupsList();
        app.getGroupHelper().createGroup(new GroupObject("test1", "test2", "test3"));
    }

}
