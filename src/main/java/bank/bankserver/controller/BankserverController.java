package bank.bankserver.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.server.ResponseStatusException;

import bank.bankserver.domain.User;
import bank.bankserver.repository.UserRepository;

@Controller
@RequestMapping("/users")
public class BankserverController {
    private final UserRepository userRepository;

    public BankserverController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("")
    public User createUser(@RequestBody User user) {
        if (userRepository.findByUserId(user.getUserId()).isPresent()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "User already exists");
        }
        return userRepository.save(user);
    }
}
