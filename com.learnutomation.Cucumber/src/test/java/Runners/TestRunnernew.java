package Runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(features="features",glue="stepDefinitions",
plugin= {"html:target/cucumber.html-report","json:target/cucumber.json",
		"pretty:target/cucumber-pretty.txt","usage:target/cucumber-usage.json",
		"junit:target/cucumber-result.xml"}
)
public class TestRunnernew {
}
