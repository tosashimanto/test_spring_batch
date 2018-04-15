package jp.co.test;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Fruit {


    private String name;
    private int price;

    public Fruit() {
    }

    public Fruit(String name, int price) {
        this.name = name;
        this.price = price;
    }
}
