package com.spsolutions.grand.resources.master;

import com.spsolutions.grand.domain.master.Item;
import com.spsolutions.grand.domain.master.ItineraryCategory;
import com.spsolutions.grand.domain.master.Venue;
import com.spsolutions.grand.service.master.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Stelan Briyan
 */
@RestController
@RequestMapping(value = "/item/")
public class ItemAPI {

    @Autowired
    private ItemService itemService;

    @PostMapping(value = "saveCategory")
    public void saveCategory(@RequestBody ItineraryCategory category) {
        itemService.saveCategory(category);
    }

    @GetMapping(value = "findActiveCategory")
    public List<Venue> findActiveCategory() {
        return itemService.findActiveCategory();
    }

    @PostMapping(value = "saveItem")
    public void saveItem(@RequestBody Item item) {
        itemService.saveItem(item);
    }

    @GetMapping(value = "findItem")
    public List<Item> findItem() {
        return itemService.findItem();
    }

    @GetMapping(value = "findItemByCategory/{fkCategory}")
    public List<Item> findItemByCategory(@PathVariable("fkCategory") Long fkCategory) {
        return itemService.findItemByCategory(fkCategory);
    }

}
