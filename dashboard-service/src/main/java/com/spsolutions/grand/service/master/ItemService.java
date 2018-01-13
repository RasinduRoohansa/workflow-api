package com.spsolutions.grand.service.master;

import com.spsolutions.grand.domain.EdgeDocument;
import com.spsolutions.grand.domain.master.Item;
import com.spsolutions.grand.domain.master.ItineraryCategory;
import com.spsolutions.grand.domain.master.Venue;
import com.spsolutions.grand.mappers.DocumentMapper;
import com.spsolutions.grand.mappers.master.ItemMapper;
import com.spsolutions.grand.service.FileService;
import com.spsolutions.grand.util.ArchiveUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Stelan Briyan
 */
@Service
public class ItemService {

    @Autowired
    private ItemMapper itemMapper;

    @Autowired
    private DocumentMapper documentMapper;

    @Autowired
    private FileService fileService;

    @Value("${archive.path}")
    private String archivePath;

    public void saveCategory(ItineraryCategory category) {
        this.itemMapper.saveCategory(category);
    }

    public List<Venue> findActiveCategory() {
        return itemMapper.findActiveCategory();
    }

    public void saveItem(Item item) {
        if (item.getImage() != null && item.getFkDocument() == null) {
            EdgeDocument edgeDocument = new ArchiveUtils().writeToFile(item.getImage(), this.archivePath, item.getItemName(), true);
            edgeDocument.setCreatedBy(item.getCreatedBy());
            documentMapper.saveDocument(edgeDocument);
            item.setFkDocument(edgeDocument.getId());
        }

        if (item.getId() == null) {
            this.itemMapper.saveItem(item);
        } else {
            this.itemMapper.updateItem(item);
        }
    }

    public List<Item> findItem() {
        List<Item> items = itemMapper.findItem();
        items.stream().forEach(item -> {
            if (item.getImage() != null) {
                item.setImage(this.fileService.findThumbnail(item.getImage(), item.getExt()));
            }
        });
        return items;
    }

    public List<Item> findItemByCategory(Long fkCategory) {
        List<Item> items = itemMapper.findItemByCategory(fkCategory);
        items.stream().forEach(item -> {
            if (item.getImage() != null) {
                item.setImage(this.fileService.findThumbnail(item.getImage(), item.getExt()));
            }
        });
        return items;
    }
}
