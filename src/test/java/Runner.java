import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/smoketest.feature",
        glue = "org.example.stepdefinitions",
        tags = "@Smoke",
        plugin = {"pretty", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"}
)
public class Runner {
}
