package x.mart.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import x.mart.Models.Item;
import x.mart.Services.ItemService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping("/items")
    public ResponseEntity<?> getAllItems() {
        return ResponseEntity.ok(itemService.findAllItems());
    }

    @GetMapping("/items/{rfid}")
    public ResponseEntity<?> getItemByRfid(String rfid) {
        return ResponseEntity.ok(itemService.findItemByRfid(rfid));
    }

    @PostMapping("/items")
    public ResponseEntity<?> createItem(Item item) {
        return ResponseEntity.ok(itemService.createItem(item));
    }

    @PutMapping("/items/{rfid}")
    public ResponseEntity<?> updateItem(String rfid, Item item) {
        return itemService.updateItem(rfid, item);
    }

    @DeleteMapping("/items/{rfid}")
    public ResponseEntity<?> deleteItem(String rfid) {
        itemService.deleteItem(rfid);
        return ResponseEntity.ok("Item deleted");
    }
}
