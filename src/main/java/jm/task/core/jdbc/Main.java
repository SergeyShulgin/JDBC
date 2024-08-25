package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        UserService userService = new UserServiceImpl();
        userService.createUsersTable();
        userService.saveUser("Мария", "Иванова", (byte) 21);
        userService.saveUser("Лиза", "Иванова", (byte) 21);
        userService.saveUser("Игорь", "Прохоров", (byte) 47);
        userService.saveUser("Владислав", "Петренко", (byte) 50);
        userService.cleanUsersTable();
        userService.getAllUsers();
        userService.dropUsersTable();
    }
}
