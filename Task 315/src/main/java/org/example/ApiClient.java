package org.example;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class ApiClient {
    private final String BASE_URL = "http://94.198.50.185:7081/api/users";
    private final RestTemplate restTemplate = new RestTemplate();
    private String sessionId;

    // Метод для получения списка всех пользователей
    public List<User> getAllUsers() {
        ResponseEntity<List<User>> response = restTemplate.exchange(
                BASE_URL,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>() {}
        );

        // Сохраняем session id из заголовков
        HttpHeaders headers = response.getHeaders();
        this.sessionId = headers.getFirst(HttpHeaders.SET_COOKIE);

        return response.getBody();
    }

    // Метод для добавления пользователя
    public String addUser(User user) {
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.COOKIE, this.sessionId);
        HttpEntity<User> request = new HttpEntity<>(user, headers);

        ResponseEntity<String> response = restTemplate.exchange(
                BASE_URL,
                HttpMethod.POST,
                request,
                String.class
        );

        return response.getBody(); // Возвращает первую часть кода
    }

    // Метод для изменения пользователя
    public String updateUser(User user) {
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.COOKIE, this.sessionId);
        HttpEntity<User> request = new HttpEntity<>(user, headers);

        ResponseEntity<String> response = restTemplate.exchange(
                BASE_URL,
                HttpMethod.PUT,
                request,
                String.class
        );

        return response.getBody(); // Возвращает вторую часть кода
    }

    // Метод для удаления пользователя
    public String deleteUser(Long id) {
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.COOKIE, this.sessionId);
        HttpEntity<Void> request = new HttpEntity<>(headers);

        ResponseEntity<String> response = restTemplate.exchange(
                BASE_URL + "/" + id,
                HttpMethod.DELETE,
                request,
                String.class
        );

        return response.getBody(); // Возвращает третью часть кода
    }
}