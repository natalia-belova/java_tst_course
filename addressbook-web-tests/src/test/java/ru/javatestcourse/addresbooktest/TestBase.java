package ru.javatestcourse.addresbooktest;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class TestBase {
    private WebDriver wd;

    @BeforeMethod(alwaysRun = true)
    public void setUp() throws Exception {
      wd = new FirefoxDriver();
      //wd = new ChromeDriver();
      wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
      gotoMainPage();
      login("admin","secret");
    }

    private void gotoMainPage() {
      wd.get("http://localhost/addressbook/addressbook/");
    }

    private void login(String username, String password) {
      wd.findElement(By.name("user")).sendKeys(username);
      wd.findElement(By.name("pass")).sendKeys(password);
      wd.findElement(By.xpath("//input[@value='Login']")).click();
    }

    protected void gotoGroupsPage() {
      wd.findElement(By.linkText("group page")).click();
    }

    protected void clickDeleteGroup() {
        wd.findElement(By.name("delete")).click();
    }

    protected void submitGroupForm() {
      wd.findElement(By.name("submit")).click();
    }

    protected void enterGroupFormValues(GroupObject groupObject) {
      wd.findElement(By.name("group_name")).click();
      wd.findElement(By.name("group_name")).sendKeys(groupObject.getName());
      wd.findElement(By.name("group_header")).click();
      wd.findElement(By.name("group_header")).sendKeys(groupObject.getHeader());
      wd.findElement(By.name("group_footer")).click();
      wd.findElement(By.name("group_footer")).sendKeys(groupObject.getFooter());
    }

    protected void initiateNewGroup() {
      wd.findElement(By.name("new")).click();
    }

    protected void gotoGroupsList() {
      wd.findElement(By.linkText("groups")).click();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() throws Exception {
      logout();
      wd.quit();
    }

    protected void clickHomePage() {
        clickLinkWithText("home page");
    }

    private void clickLinkWithText(String linkText) {
        wd.findElement(By.linkText(linkText)).click();
    }


    protected void clickEnterContact() {
        wd.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
    }

    protected void enterNewContactData(ContactObject contactObject) {
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

    protected void initiateNewContactCreation() {
        clickLinkWithText("add new");
    }

    private void logout() {
      wd.findElement(By.linkText("Logout")).click();
    }

    protected void selectGroupByOrder(String groupOrder) {
        wd.findElement(By.xpath("//div[@id='content']/form/span[" + groupOrder + "]/input")).click();
    }

    private boolean isElementPresent(By by) {
      try {
        wd.findElement(by);
        return true;
      } catch (NoSuchElementException e) {
        return false;
      }
    }

    private boolean isAlertPresent() {
      try {
        wd.switchTo().alert();
        return true;
      } catch (NoAlertPresentException e) {
        return false;
      }
    }

}
