package org.carolina.bdd_project;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features", // Points to your feature files
        glue = "org.carolina.bdd_project.steps"   // Points to your step definitions
)
public class CucumberTest {
}
