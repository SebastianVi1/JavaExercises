public class Product {
    private int id;
    private String name;
    private String category;
    private double price;
    private int stock;

    public Product(int id, String name, String category, double price, int stock){
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
        this.stock = stock;
    }

    public double getPrice() {
        return price;
    }
    public void setPrice(double price){
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    @Override
    public String toString(){
        return "Product: %s \n  Price: %f  \n  Stock: %d  \n  Category: %s ".formatted(this.name, this.price, this.stock, this.category);
    }

}

