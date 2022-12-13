public class Food {
    private String name, description;
    private double price;
    private int calories;
    public Food(String name, String description, double price, int calories){
        this.name = name;
        this.price = price;
        this.description = description;
        this.calories= calories;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public int getCalories() {
        return calories;
    }
}
