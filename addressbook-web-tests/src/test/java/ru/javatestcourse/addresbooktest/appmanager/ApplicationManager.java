package ru.javatestcourse.addresbooktest.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.javatestcourse.addresbooktest.models.ContactObject;
import ru.javatestcourse.addresbooktest.models.GroupObject;
//import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ApplicationManager {
    public WebDriver wd;

    public void init() {
        wd = new FirefoxDriver();
        //wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        gotoMainPage();
        login("admin","secret");
    }

    public void gotoMainPage() {
      wd.get("http://localhost/addressbook/addressbook/");
    }

    public void login(String username, String password) {
      wd.findElement(By.name("user")).sendKeys(username);
      wd.findElement(By.name("pass")).sendKeys(password);
      wd.findElement(By.xpath("//input[@value='Login']")).click();
    }

    public void gotoGroupsPage() {
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
      wd.findElement(By.name("group_name")).sendKeys(groupObject.getName());
      wd.findElement(By.name("group_header")).click();
      wd.findElement(By.name("group_header")).sendKeys(groupObject.getHeader());
      wd.findElement(By.name("group_footer")).click();
      wd.findElement(By.name("group_footer")).sendKeys(groupObject.getFooter());
    }

    public void initiateNewGroup() {
      wd.findElement(By.name("new")).click();
    }

    public void gotoGroupsList() {
      wd.findElement(By.linkText("groups")).click();
    }

    public void stop() {
        logout();
        wd.quit();
    }

    public void clickHomePage() {
        clickLinkWithText("home page");
    }

    public void clickLinkWithText(String linkText) {
        wd.findElement(By.linkText(linkText)).click();
    }

    public void clickEnterContact() {
        wd.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
    }

    public void enterNewContactData(ContactObject contactObject) {
        wd.findElement(By.name("firstname")).click();
        wd.findElement(By.name("firstname")).clear();
        wd.findElement(By.name("firstname")).sendKeys(contactObject.getFirst_name());
        wd.findElement(By.name("lastname")).click();
        wd.findElement(By.name("lastname")).clear();
        wd.findElement(By.name("lastname")).sendKeys(contactObject.getLast_name());
        wd.findElement(By.name("address")).click();
        wd.findElement(By.name("address")).clear();
        wd.findElement(By.name("address")).sendKeys(contactObject.getAddress());
        wd.findElement(By.name("home")).click();
        wd.findElement(By.name("home")).clear();
        wd.findElement(By.name("home")).sendKeys(contactObject.getHome_phone());
        wd.findElement(By.name("email")).click();
        wd.findElement(By.name("email")).clear();
        wd.findElement(By.name("email")).sendKeys(contactObject.getEmail());
    }

    public void initiateNewContactCreation() {
        clickLinkWithText("add new");
    }

    public void logout() {
      wd.findElement(By.linkText("Logout")).click();
    }

    public void selectGroupByOrder(String groupOrder) {
        wd.findElement(By.xpath("//div[@id='content']/form/span[" + groupOrder + "]/input")).click();
    }

    public boolean isElementPresent(By by) {
      try {
        wd.findElement(by);
        return true;
      } catch (NoSuchElementException e) {
        return false;
      }
    }

    public boolean isAlertPresent() {
      try {
        wd.switchTo().alert();
        return true;
      } catch (NoAlertPresentException e) {
        return false;
      }
    }
}
