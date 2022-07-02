package ru.javatestcourse.addresbooktest.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ru.javatestcourse.addresbooktest.appmanager.ApplicationManager;

public class TestBase {

    protected final ApplicationManager app = new ApplicationManager();

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        app.init();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        app.stop();
    }


}
