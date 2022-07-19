package ru.javatestcourse.addresbooktest.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.javatestcourse.addresbooktest.models.ContactObject;
import ru.javatestcourse.addresbooktest.models.GroupObject;

import java.util.List;


public class ContactCreationTests extends TestBase {

    @Test
//    name, address, phone, email are specified
    public void testContactCreation() throws Exception {
        int before = app.getСontactHelper().getContactsAmount();
//        List<ContactObject> before = app.getСontactHelper().getContactsList();
        app.getNavigationHelper().gotoGroupsList();
        app.getGroupHelper().createGroup(new GroupObject("TestGroup1", "test2", "test3"));
        app.getСontactHelper().createNewContact(new ContactObject("Ivanov", "Ru, Spb", "123456789", "test@qa.com", "Ivan", "TestGroup1"));
        app.returnToHomePage();
        int after = app.getСontactHelper().getContactsAmount();
        Assert.assertEquals(after, before + 1);
//        List<ContactObject> after = app.getСontactHelper().getContactsList();
//        Assert.assertEquals(after.size(), before.size() + 1);
    }

    @Test
//    only first name is specified
    public void testContactCreation2() throws Exception {
        int before = app.getСontactHelper().getContactsAmount();
        app.getСontactHelper().createNewContact(new ContactObject(null, null, null, null, "Ivan", "[none]"));
        app.returnToHomePage();
        int after = app.getСontactHelper().getContactsAmount();
        Assert.assertEquals(after, before + 1);
    }

}
