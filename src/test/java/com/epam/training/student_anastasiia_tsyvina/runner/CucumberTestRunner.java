
package com.epam.training.student_anastasiia_tsyvina.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/resources/features",
    glue = "com.epam.training.student_anastasiia_tsyvina.stepdefs",
    plugin = {"pretty"},
    monochrome = true
)
public class CucumberTestRunner extends AbstractTestNGCucumberTests {
}
