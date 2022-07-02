package ru.javatestcourse.addresbooktest.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.javatestcourse.addresbooktest.models.GroupObject;

public class GroupHelper extends BaseHelper {

    public GroupHelper(WebDriver wd) {
        super(wd);
    }

    public void returnToGroupsPage() {
        click(By.linkText("group page"));
    }

    public void clickDeleteGroup() {
        click(By.name("delete"));
    }

    public void submitGroupForm() {
        click(By.name("submit"));
    }

    public void enterGroupFormValues(GroupObject groupObject) {
        type(By.name("group_name"), groupObject.getName());
        type(By.name("group_header"), groupObject.getHeader());
        type(By.name("group_footer"), groupObject.getFooter());
    }

    public void initiateNewGroup() {
        click(By.name("new"));
    }

    public void selectGroupByOrder(String groupOrder) {
        click(By.xpath("//div[@id='content']/form/span[" + groupOrder + "]/input"));
    }
}
