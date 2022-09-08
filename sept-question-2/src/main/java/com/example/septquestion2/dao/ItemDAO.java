package com.example.septquestion2.dao;

import com.example.septquestion2.model.Item;
import org.springframework.stereotype.Repository;
import com.example.septquestion2.model.Items;

@Repository
public class ItemDAO {
    private static Items list = new Items();

    static {
        list.getItemList().add( new Item("01", "item 1", "this is item 1", 21.00));
        list.getItemList().add( new Item("02", "item 2", "this is item 2", 69.00));
        list.getItemList().add( new Item("03", "item 3", "this is item 3", 420.00));
    }

    public Items getAllItems(){
        return list;
    }

    public void addItem(Item item) {
        list.getItemList().add(item);
    }
}