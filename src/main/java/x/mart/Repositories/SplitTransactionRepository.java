package x.mart.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import x.mart.Models.SplitTransaction;

import java.util.List;

public interface SplitTransactionRepository extends JpaRepository<SplitTransaction, String>{

   @Query(value = "SELECT id, name, item_name, customer_transaction.item_price, total_item, order_time FROM " +
        "(SELECT * FROM transaction JOIN customer ON transaction.qr_code = customer.qr_code) " +
        "AS customer_transaction JOIN item ON customer_transaction.rfid = item.rfid ORDER BY order_time", nativeQuery = true)
List<SplitTransaction> getAllSplitTransaction();

}
