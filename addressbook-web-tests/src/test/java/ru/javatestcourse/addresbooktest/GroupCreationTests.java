package ru.javatestcourse.addresbooktest;

import java.time.Duration;

import org.testng.annotations.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GroupCreationTests {
  private WebDriver wd;
  @BeforeMethod(alwaysRun = true)
  public void setUp() throws Exception {
    wd = new FirefoxDriver();
    wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    gotoHomePage();
    login("admin","secret");
  }

  private void gotoHomePage() {
    wd.get("http://localhost/addressbook/addressbook/");
  }

  private void login(String username, String password) {
    wd.findElement(By.name("user")).sendKeys(username);
    wd.findElement(By.name("pass")).sendKeys(password);
    wd.findElement(By.xpath("//input[@value='Login']")).click();
  }

  @Test
  public void testGroupCreation() throws Exception {
    gotoGroupCreation();
    initiateNewGroup();
    enterGroupFormValues(new GroupObject("test1", "test2", "test3"));
    submitGroupForm();
    gotoGroupsPage();
  }

  private void gotoGroupsPage() {
    wd.findElement(By.linkText("group page")).click();
  }

  private void submitGroupForm() {
    wd.findElement(By.name("submit")).click();
  }

  private void enterGroupFormValues(GroupObject groupObject) {
    wd.findElement(By.name("group_name")).click();
    wd.findElement(By.name("group_name")).sendKeys(groupObject.getName());
    wd.findElement(By.name("group_header")).click();
    wd.findElement(By.name("group_header")).sendKeys(groupObject.getHeader());
    wd.findElement(By.name("group_footer")).click();
    wd.findElement(By.name("group_footer")).sendKeys(groupObject.getFooter());
  }

  private void initiateNewGroup() {
    wd.findElement(By.name("new")).click();
  }

  private void gotoGroupCreation() {
    wd.findElement(By.linkText("groups")).click();
  }

  @AfterMethod(alwaysRun = true)
  public void tearDown() throws Exception {
    logout();
    wd.quit();
  }

  private void logout() {
    wd.findElement(By.linkText("Logout")).click();
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
