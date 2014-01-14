package com.example.roamer.profilelist;

import java.util.ArrayList;

public class Model {

	
    public static ArrayList<Item> Items;
    public static ArrayList<Item> allItems;
    public static final String fields[] = {DatabaseSetup.colName};

    public static void LoadModel(String location) {

        Items = new ArrayList<Item>();
        allItems = new ArrayList<Item>();
        
        /*
        DatabaseSetup.init(this);
        for (int i = 0; i<100; i++)
        {
        	Database
        	Items.add(newItem())
        	
        }
        */
        System.out.println("loading items into allItems");
        
        
        allItems.add(new Item(1, "pic1.png", "George", "Boston"));
        allItems.add(new Item(2, "pic2.png", "Steve","Boston"));
        allItems.add(new Item(3, "pic3.png", "Sandy","Boston"));
        allItems.add(new Item(4, "pic4.png", "Roy","Boston"));
        allItems.add(new Item(5, "pic5.png", "Alabaster", "Boston"));
        allItems.add(new Item(6, "pic4.png", "Roy","Boston"));
        allItems.add(new Item(7, "pic5.png", "Alabaster","Boston"));
        
        System.out.println("size of allItems is:   " + allItems.size());
        System.out.println("everything loaded into allItems");
        
        
        for (Item item: allItems){        	
        	if (item.Location.equals(location))
        	{
        		int idTemp = item.Id;
        		String iconTemp = item.IconFile;
        		String nameTemp = item.Name;
        		String locTemp = item.Location;
        		
        		Items.add(new Item (idTemp,iconTemp,nameTemp,locTemp));
        	}
        }
        
        System.out.println("size of items is: " + Items.size());
        if (Items.size()<1)
        {
        	Items.add(new Item (1,"none", "none", "none"));
        }
        
        for (Item item: Items){        	

        		System.out.println(item.Id);
        		System.out.println(item.IconFile);
        		System.out.println(item.Name);
        		System.out.println(item.Location);
        		System.out.println("");
        		
        }
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