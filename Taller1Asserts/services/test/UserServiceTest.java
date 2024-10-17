package Taller1.Taller1Asserts.services.test;

import java.util.List;

import Taller1.Taller1Asserts.entities.User;
import Taller1.Taller1Asserts.services.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserServiceTest {

    private UserService userService;

    @BeforeEach
    public void setUp() {
        userService = new UserService();
    }

    // Test para assertEquals
    @Test
    public void testAddUser() {
        User user = userService.addUser("1", "Alice", 30);
        assertEquals("Alice", user.getName(), "El nombre del usuario debería ser Alice");
        assertEquals(30, user.getAge(), "La edad del usuario debería ser 30");
    }

    // Test para assertNotEquals
    @Test
    public void testUserAge() {
        User user = userService.addUser("2", "Bob", 25);
        assertNotEquals(30, user.getAge(), "La edad del usuario no debería ser 30");
    }

    // Test para assertTrue
    @Test
    public void testIsAdult() {
        User user = userService.addUser("3", "Charlie", 20);
        assertTrue(userService.isAdult(user), "Charlie debería ser un adulto");
    }

    // Test para assertFalse
    @Test
    public void testIsNotAdult() {
        User user = userService.addUser("4", "David", 16);
        assertFalse(userService.isAdult(user), "David no debería ser un adulto");
    }

    // Test para assertNotNull
    @Test
    public void testGetUserById() {
        userService.addUser("5", "Eve", 28);
        assertNotNull(userService.getUserById("5").orElse(null), "Eve debería existir");
    }

    // Test para assertArrayEquals (convertido a List)
    @Test
    public void testGetAllUsers() {
        userService.addUser("6", "Frank", 35);
        userService.addUser("7", "Grace", 40);
        List<User> expectedUsers = List.of(
                new User("6", "Frank", 35),
                new User("7", "Grace", 40)
        );
        List<User> actualUsers = userService.getAllUsers();
        assertEquals(expectedUsers.size(), actualUsers.size(), "El tamaño de la lista debería coincidir");
        for (int i = 0; i < expectedUsers.size(); i++) {
            assertEquals(expectedUsers.get(i).getName(), actualUsers.get(i).getName(), "Los nombres de los usuarios deberían coincidir");
        }
        assertArrayEquals(expectedUsers.toArray(), userService.getAllUsers().toArray());
    }

    // Test para assertThrows
    @Test
    public void testAddUserWithNegativeAge() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            userService.addUser("8", "Hank", -1);
        });
        assertEquals("La edad no puede ser negativa", exception.getMessage());
    }

    // Test para assertDoesNotThrow
    @Test
    public void testAddValidUser() {
        assertDoesNotThrow(() -> userService.addUser("9", "Ivy", 22), "No debería lanzar excepciones al agregar un usuario válido");
    }

    // Test para assertAll
    @Test
    public void testUserUpdates() {
        userService.addUser("10", "Jack", 32);
        User user = userService.updateUser("10", "Jackie", 33);
        assertAll("Verificar que el usuario ha sido actualizado correctamente",
                () -> assertEquals("Jackie", user.getName(), "El nombre debería ser Jackie"),
                () -> assertEquals(33, user.getAge(), "La edad debería ser 33")
        );
    }

    // Test para assertTimeoutPreemptively
    @Test
    public void testTimeout() {
        assertTimeoutPreemptively(java.time.Duration.ofMillis(100), () -> {
            Thread.sleep(50); // Simulación de trabajo
            userService.addUser("11", "Liam", 25);
        });
    }
}
