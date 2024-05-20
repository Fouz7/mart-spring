package x.mart.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import x.mart.Models.Item;
import x.mart.Repositories.ItemRepository;

import java.util.List;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public Item findItemByRfid(String rfid) {
        return itemRepository.findById(rfid).orElse(null);
    }

    public List<Item> findAllItems() {
        return itemRepository.findAll();
    }

    public Item createItem(Item item) {
        item.setRfid(java.util.UUID.randomUUID().toString());
        return itemRepository.save(item);
    }

    public ResponseEntity<?> updateItem(String rfid, Item item) {
        Item existingItem = itemRepository.findById(rfid).orElse(null);
        if (existingItem == null) {
            return new ResponseEntity<>("Item not found", HttpStatus.NOT_FOUND);
        }
        existingItem.setItemName(item.getItemName());
        existingItem.setItemPrice(item.getItemPrice());
        return new ResponseEntity<>(itemRepository.save(existingItem), HttpStatus.OK);
    }

    public void deleteItem(String rfid) {
        itemRepository.deleteById(rfid);
    }
}
