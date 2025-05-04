import org.junit.jupiter.api.*;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class TaskManagerTest {

    private TaskManager manager;

    @BeforeEach
    void setUp() {
        manager = new TaskManager();
        manager.addTask(new Task(1, "Test Task", "Description"));
    }

    // 🔹 Testy dla addTask
    @Test
    void testAddValidTask() {
        Task task = new Task(2, "New Task", "Some desc");
        assertTrue(manager.addTask(task));
    }

    @Test
    void testAddNullTask() {
        assertFalse(manager.addTask(null));
    }

    @Test
    void testAddDuplicateTask() {
        Task task = new Task(1, "Test Task", "Duplicate");
        assertFalse(manager.addTask(task));
    }

    @Test
    void testAddMultipleTasks() {
        assertTrue(manager.addTask(new Task(3, "Another", "Text")));
    }

    // 🔹 Testy dla removeTask
    @Test
    void testRemoveExistingTask() {
        assertTrue(manager.removeTask(1));
    }

    @Test
    void testRemoveNonExistentTask() {
        assertFalse(manager.removeTask(99));
    }

    // 🔹 Testy dla getTaskById
    @Test
    void testGetTaskById() {
        Task task = manager.getTaskById(1);
        assertNotNull(task);
        assertEquals("Test Task", task.getTitle());
    }

    @Test
    void testGetNonExistingTask() {
        assertNull(manager.getTaskById(999));
    }

    // 🔹 Testy dla updateTaskStatus
    @Test
    void testUpdateStatusSuccess() {
        assertTrue(manager.updateTaskStatus(1, true));
        assertTrue(manager.getTaskById(1).isCompleted());
    }

    @Test
    void testUpdateStatusFail() {
        assertFalse(manager.updateTaskStatus(99, true));
    }

    // 🔹 Testy dla getAllTasks
    @Test
    void testGetAllTasks() {
        List<Task> tasks = manager.getAllTasks();
        assertEquals(1, tasks.size());
    }

    @Test
    void testGetAllTasksAfterAdditions() {
        manager.addTask(new Task(2, "T2", "D2"));
        manager.addTask(new Task(3, "T3", "D3"));
        assertEquals(3, manager.getAllTasks().size());
    }
}
