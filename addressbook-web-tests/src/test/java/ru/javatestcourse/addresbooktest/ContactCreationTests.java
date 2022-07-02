package ru.javatestcourse.addresbooktest;

import java.time.Duration;

import org.testng.annotations.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ContactCreationTests {
    private WebDriver wd;


    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {
        wd = new FirefoxDriver();
        wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        gotoMainPage();
        login("admin", "secret");
    }

    private void gotoMainPage() {
        wd.get("http://localhost/addressbook/addressbook/");
    }

    private void login(String username, String password) {
        wd.findElement(By.name("user")).sendKeys(username);
        wd.findElement(By.name("pass")).sendKeys(password);
        wd.findElement(By.xpath("//input[@value='Login']")).click();
    }

    @Test
    public void testContactCreation() throws Exception {
        initiateNewContactCreation();
        enterNewContactData(new ContactObject("Ivanov", "Ru, Spb", "123456789", "test@qa.com", "Ivan"));
        clickCreate(By.xpath("//input[21]"));
        clickHomePage();
    }

    private void clickHomePage() {
        clickLinkWithText("home page");
    }

    private void clickLinkWithText(String linkText) {
        wd.findElement(By.linkText(linkText)).click();
    }

    private void clickCreate(By xpath) {
        wd.findElement(xpath).click();
    }

    private void enterNewContactData(ContactObject contactObject) {
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

    private void initiateNewContactCreation() {
        clickLinkWithText("add new");
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() throws Exception {
        logout();
        wd.quit();
    }

    private void logout() {
        clickLinkWithText("Logout");
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
