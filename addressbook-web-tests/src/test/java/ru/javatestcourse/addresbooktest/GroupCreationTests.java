package ru.javatestcourse.addresbooktest;

import org.testng.annotations.*;
public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreation() throws Exception {
        gotoGroupsList();
        initiateNewGroup();
        enterGroupFormValues(new GroupObject("test1", "test2", "test3"));
        submitGroupForm();
        gotoGroupsPage();
    }

}
