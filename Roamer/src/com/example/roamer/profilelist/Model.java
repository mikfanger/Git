package com.example.roamer.profilelist;

import java.util.ArrayList;

public class Model {

    public static ArrayList<Item> Items;

    public static void LoadModel() {

        Items = new ArrayList<Item>();
        Items.add(new Item(1, "pic1.png", "George"));
        Items.add(new Item(2, "pic2.png", "Steve"));
        Items.add(new Item(3, "pic3.png", "Sandy"));
        Items.add(new Item(4, "pic4.png", "Roy"));
        Items.add(new Item(5, "pic5.png", "Alabaster"));

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