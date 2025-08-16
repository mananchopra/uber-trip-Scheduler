package src.main.java.manager;

import src.main.java.module.User;

public class UserManager {
    public static User createUser(String name, int age, String address, String phone) {
        return new User(name, age, address, phone);
    }
    public static void printUser(User user) {
        System.out.println(user);
    }

    public static User updateUser(User user, String name, int age, String address, String phone) {
        user.setName(name);
        user.setAge(age);
        user.setAddress(address);
        user.setPhone(phone);
        return user;
    }
}