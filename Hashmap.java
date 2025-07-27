import java.util.HashSet;
import java.util.Scanner;

public class Hashmap {
    public static void main(String[] args) {
        HashSet<String> names = new HashSet<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add a Name\n2. View Unique Names\n3. Exit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    if (names.add(name)) {
                        System.out.println(name + " added!");
                    } else {
                        System.out.println(name + " is already in the list!");
                    }
                    break;
                case 2:
                    System.out.println("\nUnique Names:");
                    for (String n : names) {
                        System.out.println("- " + n);
                    }
                    break;
                case 3:
                    System.out.println("Goodbye! 😊");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}
