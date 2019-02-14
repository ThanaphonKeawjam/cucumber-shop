package ku.shop;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BuyStepdefs {

    private ProductCatalog catalog;
    private Order order;

    @Before
    public void setup() {
        catalog = new ProductCatalog();
        order = new Order();
    }

    @Given("a product (.+) with price (.+) exists and quantity (.+)")
    public void a_product_with_price_exists(String name, double price, int quant) {
        catalog.addProduct(name, price,quant);
    }

    @When("I buy (.+) with quantity (.+)")
    public void i_buy_with_quantity(String name, int quant) {
        Product prod = catalog.getProduct(name);
        order.addItem(prod, quant);
    }

    @Then("a product (.+) quantity left (.+)")
    public void quantity_left(String name, int quant){
        Product prod = catalog.getProduct(name);
        assertEquals(quant, prod.getQuant());
    }

    @Then("I can not buy (.+) ,a product have quantity (.+)")
    public void buy_more_than_product_quantity(String name, int quant){
        Product prod = catalog.getProduct(name);
        assertEquals(quant, prod.getQuant());
    }

    @Then("a product (.+) left (.+) and (.+) left (.+)")
    public void buy_two_product(String name1, int quant_left1, String name2, int quant_left2){
        Product prod1 = catalog.getProduct(name1);
        Product prod2 = catalog.getProduct(name2);

        assertEquals(quant_left1, prod1.getQuant());
        assertEquals(quant_left2, prod2.getQuant());
    }

    @Then("total should be (.+)")
    public void total_should_be(double total) {
        assertEquals(total, order.getTotal());
    }

}

