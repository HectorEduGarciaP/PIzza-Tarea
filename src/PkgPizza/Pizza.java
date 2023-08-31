package PkgPizza;

import java.util.ArrayList;
import java.util.List;

public class Pizza {

    private String name;
    private double basePrice;
    private List<Topping> toppings;

    public Pizza(String name, double basePrice) {
        this.name = name;
        this.basePrice = basePrice;
        this.toppings = new ArrayList<Topping>();
    }

    public void addTopping(Topping topping) {
        toppings.add(topping);
    }

    public void prepare() {
        double totalPrice = basePrice;
        System.out.println("Preparando pizza " + name);
        System.out.println("Ingredientes:");
        for (Topping topping : toppings) {
            System.out.println("- " + topping.getNombre());
            totalPrice += topping.getPrecio();
        }
        System.out.println("Precio total: $" + totalPrice);
    }

}