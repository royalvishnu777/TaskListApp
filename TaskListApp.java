import java.util.ArrayList;
import java.util.Scanner;

public class TaskListApp {

    private static ArrayList<String> tasks = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            showMenu();
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    addTask(scanner);
                    break;
                case 2:
                    removeTask(scanner);
                    break;
                case 3:
                    listTasks();
                    break;
                case 4:
                    System.out.println("Exiting the program.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);
    }

    private static void showMenu() {
        System.out.println("\nTask List Menu:");
        System.out.println("1. Add a task");
        System.out.println("2. Remove a task");
        System.out.println("3. List all tasks");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void addTask(Scanner scanner) {
        System.out.print("Enter the task description: ");
        String task = scanner.nextLine();
        tasks.add(task);
        System.out.println("Task added.");
    }

    private static void removeTask(Scanner scanner) {
        listTasks();
        System.out.print("Enter the number of the task to remove: ");
        int taskNumber = scanner.nextInt();
        scanner.nextLine(); // consume newline

        if (taskNumber > 0 && taskNumber <= tasks.size()) {
            tasks.remove(taskNumber - 1);
            System.out.println("Task removed.");
        } else {
            System.out.println("Invalid task number. Please try again.");
        }
    }

    private static void listTasks() {
        System.out.println("\nTask List:");
        if (tasks.isEmpty()) {
            System.out.println("No tasks added.");
        } else {
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }
    }
}