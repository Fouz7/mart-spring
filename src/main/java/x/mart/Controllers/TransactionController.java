package x.mart.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import x.mart.Models.Transaction;
import x.mart.Services.TransactionService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @GetMapping("/transactions")
    public ResponseEntity<?> getAllTransactions() {
        return ResponseEntity.ok(transactionService.findAllTransactions());
    }

    @GetMapping("/split-transactions")
    public ResponseEntity<?> getAllSplitTransactions() {
        return ResponseEntity.ok(transactionService.getAllSplitTransaction());
    }

    @GetMapping("/transactions/{id}")
    public ResponseEntity<?> getTransactionById(String id) {
        return ResponseEntity.ok(transactionService.findTransactionById(id));
    }

    @PostMapping("/transactions")
    public ResponseEntity<?> createTransaction(Transaction transaction) {
        return ResponseEntity.ok(transactionService.createTransaction(transaction));
    }

    @PutMapping("/transactions/{id}")
    public ResponseEntity<?> updateTransaction(String id, Transaction transaction) {
        return transactionService.updateTransaction(id, transaction);
    }

    @DeleteMapping("/transactions/{id}")
    public ResponseEntity<?> deleteTransaction(String id) {
        transactionService.deleteTransaction(id);
        return ResponseEntity.ok("Transaction deleted");
    }
}
