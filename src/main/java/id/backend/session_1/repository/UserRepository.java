package id.backend.session_1.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import id.backend.session_1.model.User;

@Repository
public class UserRepository {
    private final List<User> users = new ArrayList<>();
    private int nextId = 3;

    public UserRepository() {
        users.add(new User(1, "Zet Venet", "zetvenn@gmail.com"));
        users.add(new User(2, "Dzakiy A.", "dzakiyAlh@gmail.com"));
    }

    public List<User> findAll() {
        return new ArrayList<>(users);
    }

    public Optional<User> findById(int id) {
        return users.stream()
                .filter(user -> user.getId() == id)
                .findFirst();
    }

    public boolean deletById(int id) {
        return users.removeIf(user -> user.getId() == id);
    }

    public User save(User user) {
        if (user.getId() == 0) {
            user.setId(nextId++);
            users.add(user);
        } else {
            deletById(user.getId());
            users.add(user);
        }
        return user;
    }
}
