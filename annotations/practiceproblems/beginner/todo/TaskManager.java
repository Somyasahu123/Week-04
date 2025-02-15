package annotations.practiceproblems.beginner.todo;

class TaskManager {

    @Todo(task = "Implement authentication", assignedTo = "Alice", priority = "HIGH")
    public void implementAuth() {
        System.out.println("Implementing authentication...");
    }

    @Todo(task = "Optimize database queries", assignedTo = "Bob")
    public void optimizeDatabase() {
        System.out.println("Optimizing database queries...");
    }

    @Todo(task = "Refactor legacy code", assignedTo = "Charlie", priority = "LOW")
    public void refactorCode() {
        System.out.println("Refactoring legacy code...");
    }
}

