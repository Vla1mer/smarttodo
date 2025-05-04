import java.util.*;

public class TaskManager {
    private Map<Integer, Task> tasks = new HashMap<>();

    // 1. Dodaj zadanie
    public boolean addTask(Task task) {
        if (task == null || tasks.containsKey(task.getId())) return false;
        tasks.put(task.getId(), task);
        return true;
    }

    // 2. Usuń zadanie według ID
    public boolean removeTask(int id) {
        return tasks.remove(id) != null;
    }

    // 3. Pobierz zadanie według ID
    public Task getTaskById(int id) {
        return tasks.get(id);
    }

    // 4. Zaktualizuj status zadania
    public boolean updateTaskStatus(int id, boolean completed) {
        Task task = tasks.get(id);
        if (task == null) return false;
        task.setCompleted(completed);
        return true;
    }

    // 5. Pobierz listę wszystkich zadań
    public List<Task> getAllTasks() {
        return new ArrayList<>(tasks.values());
    }
}
