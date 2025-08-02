package runner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions
(
		features = { "src\\test\\resources\\TutorialsNinja.feature" }, 
		glue = { "tutorialNinjaStep","hooks" }, 
		plugin = { "pretty", "html:target/cucumber/cucumber-reports.html",
				"json:target/cucumber/cucumber-reports1.json" },
		// plugin=
		// {"pretty","html:target/cucumber/cucumber-reports.html","json:target/cucumber/cucumber-reports1.json"},

		publish = true
)

public class RunnerClass1 extends AbstractTestNGCucumberTests 
{
//	@Override
//    @DataProvider(parallel = true)
//    public Object[][] scenarios() 
//	{
//        return super.scenarios();
//    }
	@Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        // Enable parallel only if system property is passed
        boolean isParallel = Boolean.parseBoolean(System.getProperty("parallel", "false"));
        System.out.println("⚙️ Running tests in parallel mode: " + isParallel);

        // If parallel=false, TestNG runs scenarios one by one even if annotation says true
        System.setProperty("dataproviderthreadcount", isParallel ? "3" : "1");

        return super.scenarios();
    }

//	private Object[][] runSerially() 
//	{
//		Object[][] scenarios = super.scenarios();
//		// Wrapping each scenario to force single-thread execution
//		return scenarios;
//	}
}
