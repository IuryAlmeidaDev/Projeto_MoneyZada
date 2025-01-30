package br.com.iuryalmeida.MoneyZada.service;

import br.com.iuryalmeida.MoneyZada.model.Transaction;
import br.com.iuryalmeida.MoneyZada.model.TransactionType;
import br.com.iuryalmeida.MoneyZada.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository repository;

    public Transaction saveTransaction(Transaction transaction) {
        return repository.save(transaction);
    }

    public List<Transaction> getAllTransactions() {
        return repository.findAll();
    }

    public BigDecimal getBalance() {
        return repository.findAll().stream()
                .map(transaction -> transaction.getType() == TransactionType.INCOME ? transaction.getAmount() : transaction.getAmount().negate())
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }


public Transaction updateTransaction(Long id, Transaction updatedTransaction) {
    return repository.findById(id).map(transaction -> {
        transaction.setAmount(updatedTransaction.getAmount());
        transaction.setType(updatedTransaction.getType());
        transaction.setDate(updatedTransaction.getDate());
        return repository.save(transaction);
    }).orElseThrow(() -> new RuntimeException("Transaction not found"));
}
public void deleteTransaction(Long id) {
    repository.deleteById(id);
}}