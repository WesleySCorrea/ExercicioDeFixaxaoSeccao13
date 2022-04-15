package entities;

import enums.OrderStatus;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {

    private Date moment;
    private OrderStatus status;

    private Client client;
    private List<OrderItem> itens = new ArrayList<>();

    public Order(){
    }

    public Order(Date moment, OrderStatus status, Client client) {
        this.moment = moment;
        this.status = status;
        this.client = client;
    }


    public Date getMoment() {
        return moment;
    }

    public void setMoment(Date moment) {
        this.moment = moment;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<OrderItem> getItens() {
        return itens;
    }
    public void addItem(OrderItem item){
        itens.add(item);
    }
    public void removeItem(OrderItem item){
        itens.remove(item);
    }
    public double total(){
        double soma = 0;
        for (OrderItem item : itens) {
            soma += item.subTotal();
        }
        return soma;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
            for (OrderItem item: itens) {
                sb.append(item + "\n");
            }
            sb.append("Total price: $");
            sb.append(String.format("%.2f", total()));

            return sb.toString();

    }
}
