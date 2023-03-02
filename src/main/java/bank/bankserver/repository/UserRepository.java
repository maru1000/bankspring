package bank.bankserver.repository;

import java.util.List;
import java.util.Optional;

import bank.bankserver.domain.User;

public interface UserRepository {
    User save(User user);
    Optional<User> findById(Long id);
    Optional<User> findByUserId(String userId);
    List<User> findAllUser();
}


