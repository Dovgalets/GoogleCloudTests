package steps;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
//import lombok.extern.slf4j.Slf4j;

//@Slf4j
public class Hooks {


    @Before
    public void beforeScenario(Scenario scenario) {
//        log.info("**********************************************");
//        log.info("Start new test: " + scenario.getName());
//        driverFactory.createDriver();
    }

    @After
    public void afterScenario() {
//        driverFactory.tearDown();
    }
}
