package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        userService.createUsersTable();
        userService.saveUser("Ivan", "Ivanov", (byte) 32);
        userService.saveUser("Victor", "Golovin", (byte) 32);
        userService.saveUser("Danil", "Konev", (byte) 32);
        userService.saveUser("Artem", "Vasilev", (byte) 32);
        System.out.println(userService.getAllUsers());
        userService.removeUserById(2);
        userService.cleanUsersTable();
        userService.dropUsersTable();
    }
}
