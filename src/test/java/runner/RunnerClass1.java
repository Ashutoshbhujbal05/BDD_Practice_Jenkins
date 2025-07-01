package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions
(
		features= {"src\\test\\resources\\TutorialsNinja.feature"},
		glue= {"tutorialNinjaStep","hooks"},
		plugin= {"pretty","html:target/cucumber/cucumber-reports.html","json:target/cucumber/cucumber-reports1.json"},
		publish=true
)

public class RunnerClass1 extends AbstractTestNGCucumberTests
{

}
