package ru.javatestcourse.addresbooktest.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.javatestcourse.addresbooktest.models.ContactObject;

public class ContactHelper extends BaseHelper {
    public ContactHelper(WebDriver wd) {
        super(wd);
    }


    public void clickEnterContact() {
        click(By.xpath("//div[@id='content']/form/input[21]"));
    }

    public void clickEditContact() {
        click(By.xpath("//img[@alt='Edit']"));
    }

    public void deleteContact() {
        click(By.xpath("//div[@id='content']/form[2]/input[2]"));
    }

    public void updateContact() {
        click(By.name("update"));
    }

    public void enterNewContactData(ContactObject contactObject, boolean creation) {
        type(By.name("firstname"), contactObject.getFirst_name());
        type(By.name("lastname"), contactObject.getLast_name());
        type(By.name("address"), contactObject.getAddress());
        type(By.name("home"), contactObject.getHome_phone());
        type(By.name("email"), contactObject.getEmail());
//        select group if such control is presented on form (creation-only)
        if (creation) {
            new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactObject.getGroup_name());
        } else
//        element should not be presented for non-creation action
        {
            Assert.assertFalse(isElementPresent(By.name("new_group")));
        }
    }

    public void initiateNewContactCreation() {
        click(By.linkText("add new"));
    }

    public void clickDeleteContactInList() {
        click(By.xpath("//input[@value='Delete']"));
    }

    public void checkContactByOrderInList(int order) {
        click(By.xpath("//table[@id='maintable']/tbody/tr[" + (order + 1) + "]/td/input"));
    }

    public void createNewContact(ContactObject contact) {
        initiateNewContactCreation();
        enterNewContactData(contact, true);
        clickEnterContact();
    }

//    public boolean doesAnyContactExists() {
//        return isElementPresent(By.xpath("//table[@id='maintable']/tbody/tr[2]/td/input"));
//
//    }

    public void createContactIfNoOneExists(ContactObject contact) {
        if (!isElementPresent(By.xpath("//table[@id='maintable']/tbody/tr[2]/td/input"))) {
            createNewContact(contact);
        }
    }

    public int getContactsAmount() {
        return wd.findElements(By.cssSelector(".center input")).size();
    }

}

