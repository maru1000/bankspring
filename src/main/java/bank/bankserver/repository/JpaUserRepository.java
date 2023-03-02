package bank.bankserver.repository;

import bank.bankserver.domain.User;
import jakarta.persistence.EntityManager;

import java.util.List;
import java.util.Optional;

public class JpaUserRepository implements UserRepository {
    private final EntityManager em;

    public JpaUserRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public User save(User user) {
        em.persist(user);
        return user;
    }

    @Override
    public Optional<User> findById(Long id) {
        User user = em.find(User.class, id);
        return Optional.ofNullable(user);
    }

    @Override
    public Optional<User> findByUserId(String userId) {
        List<User> result = em.createQuery("select m from User m where m.userId = :name", User.class)
                .setParameter("userId", userId)
                .getResultList();
        return result.stream().findAny();
    }

    @Override
    public List<User> findAllUser() {
        return null;
    }
}
