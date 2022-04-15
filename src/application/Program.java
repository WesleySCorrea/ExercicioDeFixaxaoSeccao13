package application;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import enums.OrderStatus;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Program {

    public static void main(String[] args) throws ParseException {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Calendar calendar = Calendar.getInstance();

        System.out.println("Enter client data:");
        System.out.print("Name: ");
        String name = sc.next();
        System.out.print("Email: ");
        String email = sc.next();
        System.out.print("Birth date (DD/MM/YYYY): ");
        Date birthDate = sdf.parse(sc.next());
        Client client = new Client(name, email, birthDate);
        System.out.println(client);

        System.out.println();
        System.out.println("Enter order data:");
        System.out.print("Status: ");
        OrderStatus status = OrderStatus.valueOf(sc.next());
        Order order = new Order(new Date(), status, client);

        System.out.print("How many items to this order? ");
        int quantityItems = sc.nextInt();

        for (int i=1; i<=quantityItems; i++){
            System.out.println("Enter #" + i + " item data:");
            System.out.print("Product name: ");
            String productName = sc.next();
            System.out.print("Product price: ");
            Double productPrice = sc.nextDouble();
            Product product = new Product(productName,productPrice);
            System.out.print("Quantity: ");
            int quantity = sc.nextInt();
            OrderItem item = new OrderItem(quantity,productPrice, product);
            order.addItem(item);
        }
        Date finals = new Date();
        System.out.println();
        System.out.println("ORDER SUMMARY:");
        System.out.println("Order moment: " + sdf.format(finals));
        System.out.println("Order status: " + status);
        System.out.println(client);
        System.out.println("Order items:");
        System.out.println(order);

    }

}