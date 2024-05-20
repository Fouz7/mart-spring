package x.mart.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import x.mart.Models.SplitTransaction;
import x.mart.Models.Transaction;
import x.mart.Repositories.SplitTransactionRepository;
import x.mart.Repositories.TransactionRepository;

import java.util.List;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private SplitTransactionRepository splitTransactionRepository;

    public Transaction findTransactionById(String id) {
        return transactionRepository.findById(id).orElse(null);
    }

    public List<Transaction> findAllTransactions() {
        return transactionRepository.findAll();
    }

    public List<SplitTransaction> getAllSplitTransaction() {
        return splitTransactionRepository.getAllSplitTransaction();
    }

    public Transaction createTransaction(Transaction transaction) {
        transaction.setId(java.util.UUID.randomUUID().toString());
        return transactionRepository.save(transaction);
    }

    public ResponseEntity<?> updateTransaction(String id, Transaction transaction) {
        Transaction existingTransaction = transactionRepository.findById(id).orElse(null);
        if (existingTransaction == null) {
            return ResponseEntity.notFound().build();
        }
        existingTransaction.setTotalItem(transaction.getTotalItem());
        return ResponseEntity.ok(transactionRepository.save(existingTransaction));
    }

    public void deleteTransaction(String id) {
        transactionRepository.deleteById(id);
    }


}
