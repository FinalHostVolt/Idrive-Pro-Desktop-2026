import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Product {
    private final String name;
    private final String category;
    private final double price;
    private final int quantity;

    public Product(String name, String category, double price, int quantity) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public double getValue() {
        return price * quantity;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }
}

public class InventoryReport {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();

        products.add(new Product("Laptop", "Electronics", 899.99, 5));
        products.add(new Product("Keyboard", "Accessories", 79.50, 12));
        products.add(new Product("Mouse", "Accessories", 39.99, 20));
        products.add(new Product("Monitor", "Electronics", 249.99, 8));

        products.sort(Comparator.comparingDouble(Product::getValue).reversed());

        double totalValue = 0;

        System.out.println("Inventory Report");
        System.out.println("================");

        for (Product product : products) {
            System.out.printf(
                "%-15s | %-12s | $%.2f | %d units | $%.2f%n",
                product.getName(),
                product.getCategory(),
                product.getPrice(),
                product.getQuantity(),
                product.getValue()
            );

            totalValue += product.getValue();
        }

        System.out.println("================");
        System.out.println("Products: " + products.size());
        System.out.printf("Total Value: $%.2f%n", totalValue);
    }
}