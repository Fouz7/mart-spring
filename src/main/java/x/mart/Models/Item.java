package x.mart.Models;

import java.io.Serializable;
import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Item implements Serializable {
    @Id
    private String rfid;
    private String itemName;
    private BigDecimal itemPrice;
}