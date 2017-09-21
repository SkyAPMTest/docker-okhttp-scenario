package org.skywalking.apm.testcase.okhttp.controller;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.annotation.PostConstruct;
import org.skywalking.apm.testcase.okhttp.entity.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestRestController {

    private static final Map<Integer, User> users = new ConcurrentHashMap<>();

    @PostConstruct
    public void initUser() {
        users.put(1, new User(1, "test"));
        users.put(2, new User(2, "test"));
        users.put(2, new User(2, "test"));
    }

    @RequestMapping(value = "/rest/{id}", method = RequestMethod.GET, produces = "application/json")
    private ResponseEntity<User> getUser(@PathVariable("id") int id) {
        User currentUser = users.get(id);
        if (currentUser == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(currentUser);
    }
}
