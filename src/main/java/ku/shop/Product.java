package ku.shop;

public class Product {
    private double price;
    private String name;
    private int quant;

    public Product(String name, double price, int quant) {
        this.name = name;
        this.price = price;
        this.quant = quant;
    }

    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }
    public int getQuant() { return quant; }

    public void setName(String name) {
        this.name = name;
    }
    public void setPrice(double price) {
        if (price < 0)
            throw new IllegalArgumentException("Price must be not be negative zero");
        this.price = price;
    }
    public void setQuant(int quant){
        this.quant -= quant;
    }
}
