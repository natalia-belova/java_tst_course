package ru.javatestcourse.addresbooktest.tests;

import org.testng.annotations.*;
import ru.javatestcourse.addresbooktest.models.ContactObject;
import ru.javatestcourse.addresbooktest.models.GroupObject;


public class ContactCreationTests extends TestBase {

    @Test
//    name, address, phone, email are specified
    public void testContactCreation() throws Exception {
        app.getNavigationHelper().gotoGroupsList();
        app.getGroupHelper().createGroup(new GroupObject("TestGroup1", "test2", "test3"));
        app.getСontactHelper().createNewContact(new ContactObject("Ivanov", "Ru, Spb", "123456789", "test@qa.com", "Ivan", "TestGroup1"));
        app.returnToHomePage();
    }

    @Test
//    only first name is specified
    public void testContactCreation2() throws Exception {
        app.getСontactHelper().createNewContact(new ContactObject(null, null, null, null, "Ivan", "[none]"));
        app.returnToHomePage();
    }

}
