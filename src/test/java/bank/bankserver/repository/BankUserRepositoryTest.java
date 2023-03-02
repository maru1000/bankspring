package bank.bankserver.repository;


import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

import bank.bankserver.domain.User;

public class BankUserRepositoryTest {
    MemoryUserRepository repository = new MemoryUserRepository();

    @Test
    void testFindAllUser() {
        // given

        // when

        // then

    }

    @Test
    void testFindById() {

    }

    @Test
    void testFindByUserId() {

    }

    @Test
    void testSave() {
        // given
        User user = new User();
        user.setUserId("user1");

        // when
        repository.save(user);

        // then
        User result = repository.findByUserId(user.getUserId()).get();
        assertThat(user).isEqualTo(result);

    }
}
