package br.com.iuryalmeida.MoneyZada.controller;

import br.com.iuryalmeida.MoneyZada.model.Transaction;
import br.com.iuryalmeida.MoneyZada.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    private TransactionService service;

    @PostMapping
    public Transaction addTransaction(@RequestBody Transaction transaction) {
        return service.saveTransaction(transaction);
    }

    @GetMapping
    public List<Transaction> getAllTransactions() {
        return service.getAllTransactions();
    }

    @GetMapping("/balance")
    public BigDecimal getBalance() {
        return service.getBalance();
    }

@PutMapping("/{id}")
public Transaction updateTransaction(@PathVariable Long id, @RequestBody Transaction transaction) {
    return service.updateTransaction(id, transaction);
}
@DeleteMapping("/{id}")
public void deleteTransaction(@PathVariable Long id) {
    service.deleteTransaction(id);
}}