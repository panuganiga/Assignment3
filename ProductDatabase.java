import java.util.*;

public class ProductDatabase {
    private List<Product> products;
    private SearchIndex searchIndex;

    public ProductDatabase() {
        this.products = new ArrayList<>();
        this.searchIndex = new SearchIndex();
    }

    public void addProduct(Product product) {
        products.add(product);
        indexProduct(product);
    }

    public List<Product> searchProducts(String keyword) {
        List<String> matchingWords = searchIndex.search(keyword);
        Set<Product> resultSet = new HashSet<>();

        // Add products containing matching words to the result set
        for (String word : matchingWords) {
            for (Product product : products) {
                if (product.getName().toLowerCase().contains(word.toLowerCase()) ||
                    product.getCategory().toLowerCase().contains(word.toLowerCase()) ||
                    product.getDescription().toLowerCase().contains(word.toLowerCase())) {
                    resultSet.add(product);
                }
            }
        }

        return new ArrayList<>(resultSet);
    }

    private void indexProduct(Product product) {
        // Index product name, category, and description
        searchIndex.index(product.getName());
        searchIndex.index(product.getCategory());
        searchIndex.index(product.getDescription());
    }
}
