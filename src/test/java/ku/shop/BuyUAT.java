package ku.shop;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        format = {"pretty", "html:target/cucumber"},
//        features = {"classpath:features/buy.feature"}
        features = {"classpath:features/buywithquantity.feature"}
)
public class BuyUAT {

}

