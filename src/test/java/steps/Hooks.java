package steps;

import base.EmptyPage;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Hooks {
    EmptyPage emptyPage = new EmptyPage();

    @Before
    public void beforeScenario(Scenario scenario) {
        log.info("**********************************************");
        log.info("Start new test: " + scenario.getName());
    }

    @After
    public void afterScenario() {
        emptyPage.tearDown();
    }
}
