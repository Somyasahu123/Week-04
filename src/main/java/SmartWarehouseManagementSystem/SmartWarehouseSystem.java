package SmartWarehouseManagementSystem;
import java.util.ArrayList;
import java.util.List;

// Abstract base class
abstract class WarehouseItem {
    private String name;

    public WarehouseItem(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract void display();
}

// Subclasses for specific item types
class Electronics extends WarehouseItem {
    private String brand;

    public Electronics(String name, String brand) {
        super(name);
        this.brand = brand;
    }

    @Override
    public void display() {
        System.out.println("Electronics: " + getName() + " | Brand: " + brand);
    }
}

class Groceries extends WarehouseItem {
    private String expiryDate;

    public Groceries(String name, String expiryDate) {
        super(name);
        this.expiryDate = expiryDate;
    }

    @Override
    public void display() {
        System.out.println("Groceries: " + getName() + " | Expiry Date: " + expiryDate);
    }
}

class Furniture extends WarehouseItem {
    private String material;

    public Furniture(String name, String material) {
        super(name);
        this.material = material;
    }

    @Override
    public void display() {
        System.out.println("Furniture: " + getName() + " | Material: " + material);
    }
}

// Generic storage class
class Storage<T extends WarehouseItem> {
    private List<T> items = new ArrayList<>();

    public void addItem(T item) {
        items.add(item);
    }

    public List<T> getItems() {
        return items;
    }
}

// Utility class to display any type of WarehouseItem
class WarehouseUtility {
    public static void displayItems(List<? extends WarehouseItem> items) {
        for (WarehouseItem item : items) {
            item.display();
        }
    }
}

// Main class to demonstrate the functionality
public class SmartWarehouseSystem {
    public static void main(String[] args) {
        Storage<Electronics> electronicsStorage = new Storage<>();
        electronicsStorage.addItem(new Electronics("Laptop", "Dell"));
        electronicsStorage.addItem(new Electronics("Smartphone", "Samsung"));

        Storage<Groceries> groceriesStorage = new Storage<>();
        groceriesStorage.addItem(new Groceries("Milk", "2025-01-10"));
        groceriesStorage.addItem(new Groceries("Bread", "2024-12-05"));

        Storage<Furniture> furnitureStorage = new Storage<>();
        furnitureStorage.addItem(new Furniture("Chair", "Wood"));
        furnitureStorage.addItem(new Furniture("Table", "Metal"));

        System.out.println("=== Electronics ===");
        WarehouseUtility.displayItems(electronicsStorage.getItems());

        System.out.println("\n=== Groceries ===");
        WarehouseUtility.displayItems(groceriesStorage.getItems());

        System.out.println("\n=== Furniture ===");
        WarehouseUtility.displayItems(furnitureStorage.getItems());
    }
}
