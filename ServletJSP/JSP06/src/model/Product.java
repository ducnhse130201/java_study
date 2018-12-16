package model;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
import javax.servlet.http.HttpSessionEvent;

public class Product implements HttpSessionBindingListener {
    private String id;
    private String name;
    private double price;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public void valueBound(HttpSessionBindingEvent event){
        String attibuteName = event.getName();
        System.out.println(attibuteName + " valueBound.");
    }

    @Override
    public void valueUnbound(HttpSessionBindingEvent event){
        String attributeName = event.getName();
        System.out.println(attributeName + " valueUnbound");
    }

}
