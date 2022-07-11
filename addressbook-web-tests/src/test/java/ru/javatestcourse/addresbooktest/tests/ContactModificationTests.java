package ru.javatestcourse.addresbooktest.tests;

import org.testng.annotations.Test;
import ru.javatestcourse.addresbooktest.models.ContactObject;

public class ContactModificationTests extends TestBase {
    @Test
    public void testContactModification() throws Exception {
        app.getСontactHelper().createContactIfNoOneExists(new ContactObject(null, null, null, null, "Ivan", "[none]"));
        app.getSessionHelper().gotoMainPage();
        app.getСontactHelper().clickEditContact();
        app.getСontactHelper().enterNewContactData(new ContactObject("IvanovUPD", "Ru, SpbUPD", "123456789UPD", "testUPD@qa.com", "IvanUPD", "test1UPD"), false);
        app.getСontactHelper().updateContact();
        app.returnToHomePage();
    }
}
