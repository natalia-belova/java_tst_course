package ru.javatestcourse.addresbooktest.tests;

import org.testng.annotations.*;
import ru.javatestcourse.addresbooktest.models.ContactObject;


public class ContactCreationTests extends TestBase {

    @Test
//    name, address, phone, email are specified
    public void testContactCreation() throws Exception {
        app.getcontactHelper().initiateNewContactCreation();
        app.getcontactHelper().enterNewContactData(new ContactObject("Ivanov", "Ru, Spb", "123456789", "test@qa.com", "Ivan"));
        app.getcontactHelper().clickEnterContact();
        app.returnToHomePage();
    }

    @Test
//    only first name is specified
    public void testContactCreation2() throws Exception {
        app.getcontactHelper().initiateNewContactCreation();
        app.getcontactHelper().enterNewContactData(new ContactObject(null, null, null, null, "Ivan"));
        app.getcontactHelper().clickEnterContact();
        app.returnToHomePage();
    }

}
