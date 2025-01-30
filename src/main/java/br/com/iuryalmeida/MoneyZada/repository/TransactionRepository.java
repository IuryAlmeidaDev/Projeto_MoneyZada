package br.com.iuryalmeida.MoneyZada.repository;

import br.com.iuryalmeida.MoneyZada.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}