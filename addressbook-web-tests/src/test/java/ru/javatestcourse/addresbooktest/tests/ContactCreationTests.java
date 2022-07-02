package ru.javatestcourse.addresbooktest.tests;

import org.testng.annotations.*;
import ru.javatestcourse.addresbooktest.models.ContactObject;


public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() throws Exception {
        app.initiateNewContactCreation();
        app.enterNewContactData(new ContactObject("Ivanov", "Ru, Spb", "123456789", "test@qa.com", "Ivan"));
        app.clickEnterContact();
        app.clickHomePage();
    }

}
