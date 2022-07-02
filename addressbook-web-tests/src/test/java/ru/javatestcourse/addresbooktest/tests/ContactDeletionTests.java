package ru.javatestcourse.addresbooktest.tests;

import org.testng.annotations.Test;
import ru.javatestcourse.addresbooktest.models.ContactObject;

public class ContactDeletionTests extends TestBase {
    @Test
    public void testContactDeletion() throws Exception {
        app.getcontactHelper().clickEditContact();
        app.getcontactHelper().deleteContact();
    }
}
