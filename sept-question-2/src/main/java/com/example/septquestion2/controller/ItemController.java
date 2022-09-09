package com.example.septquestion2.controller;

import java.net.URI;

import com.example.septquestion2.dao.ItemDAO;
import com.example.septquestion2.model.Item;
import com.example.septquestion2.model.Items;

import org.apache.coyote.Response;
import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping(path = "/item")
public class ItemController {
    @Autowired
    private ItemDAO newItemDAO;

    //Get by ID
    @GetMapping(path="/item{id}")
    public Item getItemId(@RequestBody Item item) {
        return newItemDAO.getItemID(item.getId());
    }

    //Get All
    @RequestMapping(path = "/item")
    public Items getAllItems() {
        return newItemDAO.getAllItems();
    }

    //Add
    @PostMapping(path = "/item")
    public ResponseEntity<Item> addNewItem(@RequestBody Item item
    )
            throws Exception
    {

        newItemDAO.addItem(item);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/item/{id}")
                .buildAndExpand(item.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    //Update
    @PutMapping(path = "/item")
    public Items updateItem(@RequestBody Item item) {
        newItemDAO.updateItems(item.getId(), item.getName(), item.getDesc(), item.getPrice());

        return newItemDAO.getAllItems();
    }



     //Delete

    @DeleteMapping("/item")
    public Items deleteItem(@RequestBody Item item)
    {
        newItemDAO.deleteItem(item.getId());

        return newItemDAO.getAllItems();
    }


}