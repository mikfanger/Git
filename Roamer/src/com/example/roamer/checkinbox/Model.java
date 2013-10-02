package com.example.roamer.checkinbox;

import java.util.ArrayList;

public class Model {

    public static ArrayList<Item> Items;

    public static void LoadModel() {

        Items = new ArrayList<Item>();
        Items.add(new Item(1, "pic1.png", "Message1"));
        Items.add(new Item(2, "pic2.png", "Message2"));
        Items.add(new Item(3, "pic3.png", "Message3"));
        Items.add(new Item(4, "pic4.png", "Message4"));
        Items.add(new Item(5, "pic5.png", "Message5"));

    }

    public static Item GetbyId(int id){

        for(Item item : Items) {
            if (item.Id == id) {
                return item;
            }
        }
        return null;
    }

}