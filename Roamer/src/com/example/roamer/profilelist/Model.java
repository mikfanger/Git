package com.example.roamer.profilelist;

import java.util.ArrayList;

public class Model {

    public static ArrayList<Item> Items;

    public static void LoadModel() {

        Items = new ArrayList<Item>();
        Items.add(new Item(1, "pic1.png", "Alarm"));
        Items.add(new Item(2, "pic2.png", "Calculator"));
        Items.add(new Item(3, "pic3.png", "Play"));
        Items.add(new Item(4, "pic4.png", "Line Chart"));
        Items.add(new Item(5, "pic5.png", "Location"));

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