package ru.javatestcourse.addresbooktest.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.javatestcourse.addresbooktest.models.ContactObject;
//import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ApplicationManager {

    private final GroupHelper groupHelper = new GroupHelper();

    public void init() {
        groupHelper.wd = new FirefoxDriver();
        //wd = new ChromeDriver();
        groupHelper.wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        gotoMainPage();
        login("admin","secret");
    }

    public void gotoMainPage() {
      groupHelper.wd.get("http://localhost/addressbook/addressbook/");
    }

    public void login(String username, String password) {
      groupHelper.wd.findElement(By.name("user")).sendKeys(username);
      groupHelper.wd.findElement(By.name("pass")).sendKeys(password);
      groupHelper.wd.findElement(By.xpath("//input[@value='Login']")).click();
    }

    public void gotoGroupsList() {
      groupHelper.wd.findElement(By.linkText("groups")).click();
    }

    public void stop() {
        logout();
        groupHelper.wd.quit();
    }

    public void clickHomePage() {
        groupHelper.wd.findElement(By.linkText("home page")).click();
    }


    public void clickEnterContact() {
        groupHelper.wd.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
    }

    public void enterNewContactData(ContactObject contactObject) {
        groupHelper.wd.findElement(By.name("firstname")).click();
        groupHelper.wd.findElement(By.name("firstname")).clear();
        groupHelper.wd.findElement(By.name("firstname")).sendKeys(contactObject.getFirst_name());
        groupHelper.wd.findElement(By.name("lastname")).click();
        groupHelper.wd.findElement(By.name("lastname")).clear();
        groupHelper.wd.findElement(By.name("lastname")).sendKeys(contactObject.getLast_name());
        groupHelper.wd.findElement(By.name("address")).click();
        groupHelper.wd.findElement(By.name("address")).clear();
        groupHelper.wd.findElement(By.name("address")).sendKeys(contactObject.getAddress());
        groupHelper.wd.findElement(By.name("home")).click();
        groupHelper.wd.findElement(By.name("home")).clear();
        groupHelper.wd.findElement(By.name("home")).sendKeys(contactObject.getHome_phone());
        groupHelper.wd.findElement(By.name("email")).click();
        groupHelper.wd.findElement(By.name("email")).clear();
        groupHelper.wd.findElement(By.name("email")).sendKeys(contactObject.getEmail());
    }

    public void initiateNewContactCreation() {
        groupHelper.wd.findElement(By.linkText("add new")).click();
    }

    public void logout() {
      groupHelper.wd.findElement(By.linkText("Logout")).click();
    }

    public boolean isElementPresent(By by) {
      try {
        groupHelper.wd.findElement(by);
        return true;
      } catch (NoSuchElementException e) {
        return false;
      }
    }

    public boolean isAlertPresent() {
      try {
        groupHelper.wd.switchTo().alert();
        return true;
      } catch (NoAlertPresentException e) {
        return false;
      }
    }

    public GroupHelper getGroupHelper() {
        return groupHelper;
    }
}
