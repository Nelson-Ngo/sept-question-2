package com.example.septquestion2.dao;

import com.example.septquestion2.model.Item;
import org.springframework.stereotype.Repository;
import com.example.septquestion2.model.Items;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Iterator;

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

    public Item getItemID(String id){
        return list.getItemList().stream().filter(item -> id.equals(item.getId())).findAny().orElseThrow(null);
    }

    public void addItem(Item item) {
        list.getItemList().add(item);
    }

    public Item updateItems(String id, String name, String desc, double price) {
        Item holder = new Item();
        for (int x = 0; x < list.getItemList().size(); x++){
            Item item = list.getItemList().get(x);
            if (item.getId().equals(id)){
                item.setId(id);
                item.setName(name);
                item.setDesc(desc);
                item.setPrice(price);
                break;
            }
            else {
                holder = null;
            }
        }
        return holder;
    }

    public void deleteItem(String id) {
        for (int x = 0; x < list.getItemList().size(); x++){
            Item item = list.getItemList().get(x);
            if (item.getId().equals(id)){
                list.getItemList().remove(item);
                break;
            }
        }
    }
}