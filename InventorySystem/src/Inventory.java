import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private final List<Product> inventory = new ArrayList<>();

    public Inventory(){
        inventory.addAll(List.of(
                new Product(1, "Laptop", "Tech", 1233, 2),
                new Product(2, "TV", "Tech", 9899, 3),
                new Product(3, "Xbox", "Videogames", 8000, 9),
                new Product(4, "Mechanical keyboard", "Accesorios", 75.00, 15)
        ));
    }

    public List<Product> getInventory() {
        return inventory;
    }
    public void addProduct(Product product){
        inventory.add(product);
        System.out.println("Product " + product.getName() + " added to the inventory");
    }

    public List<String> minStockAlert(int minStock) {
        return inventory.stream()
                .filter(p -> p.getStock() <= minStock)
                .map(p -> p.getName().toUpperCase())
                .toList();
    }

    public Product getProductById(int id){
         return inventory.stream()
                .filter(p-> p.getId() == id)
                .findFirst().orElse(null);
    }
    public List<Product> searchPerCategory(String category){
        return inventory.stream()
                .filter(p -> p.getCategory().equals(category))
                .toList();

    }



    public void deleteProduct(int id){
        Product product = getProductById(id);
        if (product == null){
            System.out.println("The product doesn't exists");
            return;
        }
        inventory.remove(product);


    }

    public void showProducts(){
        inventory.forEach(product -> System.out.println(product.toString()));
        //or inventory.stream().forEach(System.out::println); same funcion
    }

    public double totalValue(){
        return inventory.stream()
                .mapToDouble(product -> (product.getPrice() * product.getStock()))
                .sum();
    }






}
