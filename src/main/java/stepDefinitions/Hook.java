package stepDefinitions;

import org.openqa.selenium.remote.RemoteWebDriver;

import io.cucumber.java.*;

import MyRunner.TestRunner;

public class Hook extends TestRunner {
    public RemoteWebDriver driver = this.connection;

    @Before
    public void updateName(Scenario scenario) throws InterruptedException {
        Thread.sleep(30);
        driver.executeScript("lambda-name=" + scenario.getName());
    }

    @After
    public void close_the_browser(Scenario scenario) {
        driver.executeScript("lambda-status=" + (scenario.isFailed() ? "failed" : "passed"));
        System.out.println(driver.getSessionId());
        driver.quit();
    }

}