package ru.javatestcourse.addresbooktest.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.javatestcourse.addresbooktest.models.GroupObject;

public class GroupHelper {
    private WebDriver wd;

    public GroupHelper(WebDriver wd) {
        this.wd = wd;
    }

    public void returnToGroupsPage() {
        wd.findElement(By.linkText("group page")).click();
    }

    public void clickDeleteGroup() {
        wd.findElement(By.name("delete")).click();
    }

    public void submitGroupForm() {
        wd.findElement(By.name("submit")).click();
    }

    public void enterGroupFormValues(GroupObject groupObject) {
        wd.findElement(By.name("group_name")).click();
        wd.findElement(By.name("group_name")).clear();
        wd.findElement(By.name("group_name")).sendKeys(groupObject.getName());
        wd.findElement(By.name("group_header")).click();
        wd.findElement(By.name("group_header")).clear();
        wd.findElement(By.name("group_header")).sendKeys(groupObject.getHeader());
        wd.findElement(By.name("group_footer")).click();
        wd.findElement(By.name("group_footer")).clear();
        wd.findElement(By.name("group_footer")).sendKeys(groupObject.getFooter());
    }

    public void initiateNewGroup() {
        wd.findElement(By.name("new")).click();
    }

    public void selectGroupByOrder(String groupOrder) {
        wd.findElement(By.xpath("//div[@id='content']/form/span[" + groupOrder + "]/input")).click();
    }
}
