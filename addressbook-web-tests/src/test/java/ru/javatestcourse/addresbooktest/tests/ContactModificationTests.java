package ru.javatestcourse.addresbooktest.tests;

import org.testng.annotations.Test;
import ru.javatestcourse.addresbooktest.models.ContactObject;

public class ContactModificationTests extends TestBase {
    @Test
    public void testContactModification() throws Exception {
        app.getcontactHelper().clickEditContact();
        app.getcontactHelper().enterNewContactData(new ContactObject("IvanovUPD", "Ru, SpbUPD", "123456789UPD", "testUPD@qa.com", "IvanUPD"));
        app.getcontactHelper().updateContact();
        app.returnToHomePage();
    }
}
