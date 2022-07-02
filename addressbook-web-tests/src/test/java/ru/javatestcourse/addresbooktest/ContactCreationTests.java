package ru.javatestcourse.addresbooktest;

import org.testng.annotations.*;


public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() throws Exception {
        initiateNewContactCreation();
        enterNewContactData(new ContactObject("Ivanov", "Ru, Spb", "123456789", "test@qa.com", "Ivan"));
        clickEnterContact();
        clickHomePage();
    }

}
