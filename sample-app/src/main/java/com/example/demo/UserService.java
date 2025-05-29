
package com.example.demo;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {
    private Map<Long, User> db = new HashMap<>();
    private Long idCounter = 1L;

    public User getUserById(Long id) {
        return db.getOrDefault(id, new User(id, "Default"));
    }

    public User saveUser(User user) {
        user.setId(idCounter++);
        db.put(user.getId(), user);
        return user;
    }
}
