package implement_a_shopping_cart;

import java.util.*;

class ShoppingCart {
    private Map<String, Double> productPrices = new HashMap<>(); // Product -> Price
    private LinkedHashMap<String, Integer> cart = new LinkedHashMap<>(); // Maintains order of items added

    // Add product with price
    public void addProduct(String product, double price) {
        productPrices.put(product, price);
    }

    // Add item to cart
    public void addToCart(String product, int quantity) {
        if (productPrices.containsKey(product)) {
            cart.put(product, cart.getOrDefault(product, 0) + quantity);
        } else {
            System.out.println("Product not found: " + product);
        }
    }

    // Display items in order added
    public void displayCart() {
        System.out.println("\nShopping Cart (Order Added):");
        for (var entry : cart.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue() + " units");
        }
    }

    // Display items sorted by price
    public void displayItemsByPrice() {
        TreeMap<Double, String> sortedByPrice = new TreeMap<>();
        for (var entry : productPrices.entrySet()) {
            sortedByPrice.put(entry.getValue(), entry.getKey());
        }

        System.out.println("\nProducts Sorted by Price:");
        for (var entry : sortedByPrice.entrySet()) {
            System.out.println(entry.getValue() + " -> $" + entry.getKey());
        }
    }
}

public class ShoppingCartApp {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        // Adding products with prices
        cart.addProduct("Laptop", 1000);
        cart.addProduct("Phone", 700);
        cart.addProduct("Headphones", 200);
        cart.addProduct("Mouse", 50);

        // Adding items to cart
        cart.addToCart("Phone", 1);
        cart.addToCart("Laptop", 1);
        cart.addToCart("Headphones", 2);

        cart.displayCart();
        cart.displayItemsByPrice();
    }
}

