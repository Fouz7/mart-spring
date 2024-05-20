package x.mart.Models;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Customer implements Serializable {

    @Id
    private String qrCode;
    private String name;
    private String wallet;
}
