package org.vsm;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty" ,"json:result/cucumber.json", "html:result/report.html"},
		features = {"src/test/resources/features",},
		glue = {"org.vsm.stepDefinitions"},
		tags = {"@test"}
		)

public class VSMTestRunner {

}
