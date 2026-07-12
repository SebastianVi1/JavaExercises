import java.util.List;
import java.util.Scanner;

public class Main {

    static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Inventory inventory = new Inventory();
        System.out.println(args.length);


        int option;
        do {
            printMenu();
            option = readInt(scanner, "Choose an option: ");

            switch (option) {
                case 1 -> inventory.showProducts();
                case 2 -> addProduct(scanner, inventory);
                case 3 -> searchById(scanner, inventory);
                case 4 -> searchByCategory(scanner, inventory);
                case 5 -> minStockAlert(scanner, inventory);
                case 6 -> deleteProduct(scanner, inventory);
                case 7 -> System.out.println("Total stock products value: "
                        + Formatter.numberToString(inventory.totalValue()));
                case 0 -> System.out.println("Goodbye!");
                default -> System.out.println("Invalid option. Try again.");
            }

            System.out.println();
        } while (option != 0);
    }

    private static void printMenu() {
        System.out.println("==== INVENTORY MENU ====");
        System.out.println("1. Show products");
        System.out.println("2. Add product");
        System.out.println("3. Search product by ID");
        System.out.println("4. Search products by category");
        System.out.println("5. Min stock alert");
        System.out.println("6. Delete product");
        System.out.println("7. Show total inventory value");
        System.out.println("0. Exit");
    }

    private static void addProduct(Scanner scanner, Inventory inventory) {
        int id = readInt(scanner, "ID: ");
        String name = readLine(scanner, "Name: ");
        String category = readLine(scanner, "Category: ");
        double price = readDouble(scanner);
        int stock = readInt(scanner, "Stock: ");

        inventory.addProduct(new Product(id, name, category, price, stock));
    }

    private static void searchById(Scanner scanner, Inventory inventory) {
        int id = readInt(scanner, "ID to search: ");
        Product product = inventory.getProductById(id);

        if (product == null) {
            System.out.println("Product not found.");
        } else {
            System.out.println(product);
        }
    }

    private static void searchByCategory(Scanner scanner, Inventory inventory) {
        String category = readLine(scanner, "Category to search: ");
        List<Product> products = inventory.searchPerCategory(category);

        if (products.isEmpty()) {
            System.out.println("No products found for that category.");
            return;
        }

        products.forEach(System.out::println);
    }

    private static void minStockAlert(Scanner scanner, Inventory inventory) {
        int minStock = readInt(scanner, "Minimum stock: ");
        List<String> alerts = inventory.minStockAlert(minStock);

        if (alerts.isEmpty()) {
            System.out.println("No products under or equal to that stock.");
            return;
        }

        System.out.println("Products with low stock:");
        alerts.forEach(productName -> System.out.println("- " + productName));
    }

    private static void deleteProduct(Scanner scanner, Inventory inventory) {
        int id = readInt(scanner, "ID to delete: ");
        inventory.deleteProduct(id);
    }

    private static int readInt(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid integer.");
            }
        }
    }

    private static double readDouble(Scanner scanner) {
        while (true) {
            System.out.print("Price: ");
            try {
                return Double.parseDouble(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }

    private static String readLine(Scanner scanner, String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }
}
