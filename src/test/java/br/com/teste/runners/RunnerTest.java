package br.com.teste.runners;

import java.io.File;


import com.cucumber.listener.Reporter;
import lombok.CustomLog;
import org.junit.AfterClass;
import org.junit.runner.RunWith;



import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)

@CucumberOptions(features = "./features", glue = { "br.com.teste.steps" },
		tags = {"@transferenciaComSucesso"},
		plugin = { "pretty"}, monochrome = true)

public class RunnerTest {



}
