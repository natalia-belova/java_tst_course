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

    public void clickEditGroup() {
        click(By.name("edit"));
    }

    public void submitGroupForm() {
        click(By.name("submit"));
    }

    public void updateGroupForm() {
        click(By.name("update"));
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

    public void createGroup(GroupObject group) {
        initiateNewGroup();
        enterGroupFormValues(group);
        submitGroupForm();
        returnToGroupsPage();
    }

    public boolean doesSomeGroupExists() {
        return isElementPresent(By.xpath("//div[@id='content']/form/span[1]/input"));
    }
}
