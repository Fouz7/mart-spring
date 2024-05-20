package x.mart.Models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Entity
@Data
public class SplitTransaction implements Serializable {
    @Id
    private String id;
    private String name;
    private String itemName;
    private BigDecimal itemPrice;
    private Integer totalItem;
    @Temporal(TemporalType.TIMESTAMP)
    private Date orderTime;
}
