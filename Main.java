import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Create a new product database
        ProductDatabase database = new ProductDatabase();

        // Add some products to the database
        Product product1 = new Product("Laptop", "Electronics", "High-performance laptop");
        Product product2 = new Product("Smartphone", "Electronics", "Latest smartphone model");
        Product product3 = new Product("Book", "Books", "Bestselling novel");
        Product product4 = new Product("Pen", "Stationery", "Ballpoint pen");
        Product product5 = new Product("Pencil", "Stationery", "HB pencil");
        // Add more products here...

        database.addProduct(product1);
        database.addProduct(product2);
        database.addProduct(product3);
        database.addProduct(product4);
        database.addProduct(product5);
        // Add more products here...

        // Prompt the user to enter a search keyword
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a search keyword: ");
        String keyword = scanner.nextLine();

        // Search for products by the entered keyword
        List<Product> searchResults = database.searchProducts(keyword);

        // Print search results
        System.out.println("Search results:");
        if (searchResults.isEmpty()) {
            System.out.println("No matching products found.");
        } else {
            for (Product product : searchResults) {
                System.out.println(product.getName() + " - " + product.getDescription());
            }
        }

        // Close the scanner
        scanner.close();
    }
}
