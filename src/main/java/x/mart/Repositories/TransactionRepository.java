package x.mart.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import x.mart.Models.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, String>{
}
