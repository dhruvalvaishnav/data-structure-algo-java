package com.demo.interviews;

import java.util.*;

public class MindTree {
    public static void main(String[] args) {

//        1. pgm to find most repeated word in a string
        String str = "Hi My name is Dhruval Dhruval Vaishnav";
        String[] strArr = str.split(" ");
        Map<String, String> map = new HashMap<>();
        for (String s : strArr) {
            if (map.containsKey(s)) {
                System.out.println("Here found the repeated word : " + s);
            }
            map.put(s, "ADDED");
        }

//        2.pgm to remove duplicate elements from an array
        int[] arr = {1, 4, 5, 4, 0, 2, 8, 1};
        //set-> add -> O(1)
        //hashMap -> O(n)
        // O(n^2) -> two for loops

        Map<Integer, String> integerStringMap = new HashMap<>();
        for (int i : arr) {
            if (map.containsKey(i)) {
                break;
            }
            integerStringMap.put(i, "ADDED");
        }

        for (int i : integerStringMap.keySet()) {
            System.out.print("Output array : " + i);
        }
    }
}

/*
//3.create a rest controller for user information

package com.demo.controllers;

@RestController("/users")
public class UserController {

    private UserService userService;

    @Autowired
    UserController(UserService userService ){
        this.userService = userService;
    }

    @GetMapping("/")
    public List<User> findAllUsers() {
        return userService.findAll();
    }

    @PostMapping("/")
    public User addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @DeleteMapping("/id")
    public void deleteUser(@PathParam @Required @Valid int id) {
        return userService.deleteUser(id);
    }

    @PutMapping("/id")
    public User UpdateUser(@PathParam @Required @Valid int id) {
        return userService.updateUser(id);
    }

}

*/

// Hashmap & Hashtable
// Switch case - String
// lambda - () -> { }
// sleep vs wait
// way to create a spring boot app -> start.spring.io, through IDE, through STS
// how to monitor restAPIS - spring boot app - actuator