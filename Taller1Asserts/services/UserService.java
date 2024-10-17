package Taller1.Taller1Asserts.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import Taller1.Taller1Asserts.entities.User;

public class UserService {
    private List<User> users = new ArrayList<>();

    // Método para agregar un usuario
    public User addUser(String id, String name, int age) {
        if (age < 0) {
            throw new IllegalArgumentException("La edad no puede ser negativa");
        }
        User user = new User(id, name, age);
        users.add(user);
        return user;
    }

    // Método para obtener un usuario por ID
    public Optional<User> getUserById(String id) {
        return Optional.ofNullable(users.stream().filter(u -> u.getId().equals(id)).findFirst().orElse(null));
    }

    // Método para actualizar un usuario
    public User updateUser(String id, String name, int age) {
        Optional<User> optionalUser = getUserById(id);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setName(name);
            user.setAge(age);
            return user;
        }
        throw new IllegalArgumentException("Usuario no encontrado");
    }

    // Método para eliminar un usuario
    public boolean deleteUser(String id) {
        return users.removeIf(u -> u.getId().equals(id));
    }

    // Método para obtener todos los usuarios
    public List<User> getAllUsers() {
        return new ArrayList<>(users);
    }

    // Método para validar la edad del usuario
    public boolean isAdult(User user) {
        return user.getAge() >= 18;
    }
}