package com.spsolutions.grand.mappers.master;

import com.spsolutions.grand.domain.master.Item;
import com.spsolutions.grand.domain.master.ItineraryCategory;
import com.spsolutions.grand.domain.master.Venue;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ItemMapper {
    void saveCategory(ItineraryCategory category);

    List<Venue> findActiveCategory();

    void saveItem(Item item);

    List<Item> findItem();

    List<Item> findItemByCategory(Long fkCategory);

    void updateItem(Item item);
}
