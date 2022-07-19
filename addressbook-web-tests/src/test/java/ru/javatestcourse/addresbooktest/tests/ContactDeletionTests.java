package ru.javatestcourse.addresbooktest.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.javatestcourse.addresbooktest.models.ContactObject;

public class ContactDeletionTests extends TestBase {
    @Test
//    from contact details page
    public void testContactDeletion() throws Exception {
        app.getСontactHelper().createContactIfNoOneExists(new ContactObject(null, null, null, null, "Ivan", "[none]"));
        app.getSessionHelper().gotoMainPage();
        int before = app.getСontactHelper().getContactsAmount();
        app.getСontactHelper().clickEditContactByOrder(before - 1);
        app.getСontactHelper().deleteContact();
        app.getSessionHelper().gotoMainPage();
        int after = app.getСontactHelper().getContactsAmount();
        Assert.assertEquals(after, before - 1);
    }


    @Test
//    from contact list (home) page
    public void testContactDeletionFromList() throws Exception {
        app.getСontactHelper().createContactIfNoOneExists(new ContactObject(null, null, null, null, "Ivan", "[none]"));
        app.getSessionHelper().gotoMainPage();
        int before = app.getСontactHelper().getContactsAmount();
        app.getСontactHelper().checkContactByOrderInList(before - 1);
        app.getСontactHelper().clickDeleteContactInList();
        app.getNavigationHelper().acceptAlert();
        app.getSessionHelper().gotoMainPage();
        int after = app.getСontactHelper().getContactsAmount();
        Assert.assertEquals(after, before - 1);
    }
}
