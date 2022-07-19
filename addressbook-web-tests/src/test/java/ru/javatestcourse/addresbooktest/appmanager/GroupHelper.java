package ru.javatestcourse.addresbooktest.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.javatestcourse.addresbooktest.models.GroupObject;

import java.util.ArrayList;
import java.util.List;

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

    public void selectGroupByOrder(int groupOrder) {
        wd.findElements(By.name("selected[]")).get(groupOrder).click();
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

    public int getGroupCount() {
        return wd.findElements(By.cssSelector(".group")).size();
    }

    public List<GroupObject> getGroupList() {
        List<GroupObject> groups = new ArrayList<GroupObject>();
        List<WebElement> elements = wd.findElements(By.cssSelector("span.group"));
        for (WebElement element : elements) {
            String name = element.getText();
            String id = element.findElement(By.tagName("input")).getAttribute("value");
            GroupObject group = new GroupObject(id, name, null, null);
            groups.add(group);
        }
        return groups;
    }
}
