package pojo;

public class MenuItem {
    private final String name;
    private double price;

    public MenuItem(String name, double price) {
        if (name == null || name.isEmpty() || price <= 0) {
            throw new IllegalArgumentException("Invalid menu item");
        }
        this.name = name;
        this.price = price;
    }

    public String getName() { return name; }
    public double getPrice() { return price; }

    public void updatePrice(double price) {
        if (price <= 0) throw new IllegalArgumentException("Invalid price");
        this.price = price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
