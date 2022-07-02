package ru.javatestcourse.addresbooktest.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.javatestcourse.addresbooktest.models.ContactObject;

public class ContactHelper  extends BaseHelper {
    public ContactHelper(WebDriver wd) {
        super(wd);
    }


    public void clickEnterContact() {
        click(By.xpath("//div[@id='content']/form/input[21]"));
    }

    public void enterNewContactData(ContactObject contactObject) {
        type(By.name("firstname"), contactObject.getFirst_name());
        type(By.name("lastname"), contactObject.getLast_name());
        type(By.name("address"), contactObject.getAddress());
        type(By.name("home"), contactObject.getHome_phone());
        type(By.name("email"), contactObject.getEmail());
    }

    public void initiateNewContactCreation() {
        click(By.linkText("add new"));
    }
}

