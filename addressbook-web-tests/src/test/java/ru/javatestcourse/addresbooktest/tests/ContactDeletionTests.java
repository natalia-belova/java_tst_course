package ru.javatestcourse.addresbooktest.tests;

import org.testng.annotations.Test;
import ru.javatestcourse.addresbooktest.models.ContactObject;

public class ContactDeletionTests extends TestBase {
    @Test
//    from contact details page
    public void testContactDeletion() throws Exception {
        app.getcontactHelper().clickEditContact();
        app.getcontactHelper().deleteContact();
    }


    @Test
//    from contact list (home) page
    public void testContactDeletionFromList() throws Exception {
        app.getcontactHelper().checkContactByOrderInList(1);
        app.getcontactHelper().clickDeleteContactInList();
        app.getNavigationHelper().acceptAlert();
    }
}
