package bank.bankserver.repository;

import bank.bankserver.domain.User;

import java.util.*;

public class MemoryUserRepository implements UserRepository {
    private static Map<Long, User> store = new HashMap<>();
    private static long sequence = 0L;
    
    @Override
    public User save(User user) {
        user.setId(++sequence);
        store.put(user.getId(), user);
        return user;
    }

    @Override
    public Optional<User> findById(Long Id) {
        return Optional.ofNullable(store.get(Id));
    }

    @Override
    public Optional<User> findByUserId(String userId) {
        // TODO Auto-generated method stub
        return store.values().stream()
                .filter(user -> user.getUserId().equals(userId))
                .findAny();
    }

    @Override
    public List<User> findAllUser() {
        // TODO Auto-generated method stub
        return new ArrayList<>(store.values());
    }
    
}
