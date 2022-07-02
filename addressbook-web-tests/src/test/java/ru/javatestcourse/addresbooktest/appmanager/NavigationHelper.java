package ru.javatestcourse.addresbooktest.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper  extends BaseHelper {

    public NavigationHelper(WebDriver wd) {
        super(wd);
    }

    public void gotoGroupsList() {
        click(By.linkText("groups"));
    }
}
