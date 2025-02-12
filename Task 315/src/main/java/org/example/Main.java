package org.example;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ApiClient apiClient = new ApiClient();

        // 1. Получаем список всех пользователей
        List<User> users = apiClient.getAllUsers();
        System.out.println("Список пользователей: " + users);

        // 2. Добавляем нового пользователя
        User newUser = new User();
        newUser.setId(3L);
        newUser.setName("James");
        newUser.setLastName("Brown");
        newUser.setAge((byte) 30);

        String codePart1 = apiClient.addUser(newUser);
        System.out.println("Часть кода 1: " + codePart1);

        // 3. Изменяем пользователя
        User updatedUser = new User();
        updatedUser.setId(3L);
        updatedUser.setName("Thomas");
        updatedUser.setLastName("Shelby");
        updatedUser.setAge((byte) 35);

        String codePart2 = apiClient.updateUser(updatedUser);
        System.out.println("Часть кода 2: " + codePart2);

        // 4. Удаляем пользователя
        String codePart3 = apiClient.deleteUser(3L);
        System.out.println("Часть кода 3: " + codePart3);

        // 5. Собираем итоговый код
        String finalCode = codePart1 + codePart2 + codePart3;
        System.out.println("Итоговый код: " + finalCode);
    }
}