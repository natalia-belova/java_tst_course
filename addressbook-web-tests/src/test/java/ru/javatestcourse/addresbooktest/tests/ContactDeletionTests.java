package ru.javatestcourse.addresbooktest.tests;

import org.testng.annotations.Test;
import ru.javatestcourse.addresbooktest.models.ContactObject;

public class ContactDeletionTests extends TestBase {
    @Test
//    from contact details page
    public void testContactDeletion() throws Exception {
        app.getСontactHelper().createContactIfNoOneExists(new ContactObject(null, null, null, null, "Ivan", "[none]"));
        app.getSessionHelper().gotoMainPage();
        app.getСontactHelper().clickEditContact();
        app.getСontactHelper().deleteContact();
    }


    @Test
//    from contact list (home) page
    public void testContactDeletionFromList() throws Exception {
        app.getСontactHelper().createContactIfNoOneExists(new ContactObject(null, null, null, null, "Ivan", "[none]"));
        app.getSessionHelper().gotoMainPage();
        app.getСontactHelper().checkContactByOrderInList(1);
        app.getСontactHelper().clickDeleteContactInList();
        app.getNavigationHelper().acceptAlert();
    }
}
