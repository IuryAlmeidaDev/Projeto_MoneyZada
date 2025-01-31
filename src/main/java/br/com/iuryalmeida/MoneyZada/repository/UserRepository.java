package br.com.iuryalmeida.MoneyZada.repository;

import br.com.iuryalmeida.MoneyZada.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}