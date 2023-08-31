import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Topping {
    private String nombre;
    private double precio;

    public Topping(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }
}

class Pizza {
    private String nombre;
    private double precioBase;
    private List<Topping> toppings = new ArrayList<>();

    public Pizza(String nombre, double precioBase) {
        this.nombre = nombre;
        this.precioBase = precioBase;
    }

    public void addTopping(Topping topping) {
        toppings.add(topping);
    }

    public double calcularPrecioTotal() {
        double precioTotal = precioBase;
        for (Topping topping : toppings) {
            precioTotal += topping.getPrecio();
        }
        return precioTotal;
    }

    public void prepare() {
        System.out.println("Preparando la pizza " + nombre);
        System.out.println("Precio base: Q" + precioBase);
        System.out.println("Toppings:");
        for (Topping topping : toppings) {
            System.out.println("- " + topping.getNombre() + ": Q" + topping.getPrecio());
        }
        System.out.println("Precio total: Q" + calcularPrecioTotal());
    }
}

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Topping> availableToppings = createAvailableToppings();

        System.out.println("Bienvenido a la Pizzería Palma!");

        System.out.println("Nuestros ingredientes disponibles son:");
        for (int i = 0; i < availableToppings.size(); i++) {
            System.out.println((i + 1) + ". " + availableToppings.get(i).getNombre() + " - Precio: Q" + availableToppings.get(i).getPrecio());
        }

        System.out.print("¿Cuál es el nombre de la pizza? ");
        String pizzaName = scanner.nextLine();

        System.out.print("¿Cuánto cuesta la pizza base? ");
        double basePrice = scanner.nextDouble();
        scanner.nextLine();

        Pizza pizza = new Pizza(pizzaName, basePrice);

        int toppingChoice;
        do {
            System.out.print("Selecciona un ingrediente por su número (0 para finalizar): ");
            toppingChoice = scanner.nextInt();
            scanner.nextLine();

            if (toppingChoice > 0 && toppingChoice <= availableToppings.size()) {
                Topping selectedTopping = availableToppings.get(toppingChoice - 1);
                pizza.addTopping(selectedTopping);
                System.out.println(selectedTopping.getNombre() + " agregado a la pizza!");
            } else if (toppingChoice != 0) {
                System.out.println("Opción inválida");
            }
        } while (toppingChoice != 0);

        pizza.prepare();
    }

    public static List<Topping> createAvailableToppings() {
        List<Topping> toppings = new ArrayList<>();
        toppings.add(new Topping("Tomate", 10));
        toppings.add(new Topping("Cebolla", 5));
        toppings.add(new Topping("Peperoni", 20));
        toppings.add(new Topping("Jamón", 15));
        toppings.add(new Topping("Champiñones", 12));
        toppings.add(new Topping("Aceitunas", 8));
        toppings.add(new Topping("Queso extra", 18));
        toppings.add(new Topping("Orilla de Queso", 20));
        toppings.add(new Topping("Piña", 5));



        return toppings;
    }
}