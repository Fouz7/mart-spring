package x.mart.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import x.mart.Models.Item;

public interface ItemRepository extends JpaRepository<Item, String>{
}
