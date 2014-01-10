package com.example.roamer.profilelist;

import java.util.ArrayList;

public class Model {

    public static ArrayList<Item> Items;

    public static void LoadModel() {

        Items = new ArrayList<Item>();
        Items.add(new Item(1, "pic1.png", "George", "Chicago"));
        Items.add(new Item(2, "pic2.png", "Steve","Boston"));
        Items.add(new Item(3, "pic3.png", "Sandy","Chicago"));
        Items.add(new Item(4, "pic4.png", "Roy","Boston"));
        Items.add(new Item(5, "pic5.png", "Alabaster", "Cleveland"));
        Items.add(new Item(6, "pic4.png", "Roy","Oakland"));
        Items.add(new Item(7, "pic5.png", "Alabaster","Detroit"));

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