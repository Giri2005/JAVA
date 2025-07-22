import java.util.Scanner;

class General {
    void greet(String name, int age) {
        System.out.println("Hello, " + name + "! You are " + age + " years old.");
    }

    void processString(String name) {
        System.out.println("Your name in uppercase: " + name.toUpperCase() 
        + " (Length: " + name.length() + ")");
    }

    void printNumbers(int favNum) {
        System.out.println("Numbers from 1 to " + favNum + " (skipping multiples of 3):");
        for (int i = 1; i <= favNum; i++) {
            if (i % 3 == 0) continue;
            System.out.print(i + " ");
        }
        System.out.println();
    }

    void calculateSumAndAverage(int favNum) {
        int sum = 0;
        for (int i = 1; i <= favNum; i++) {
            sum += i;
        }
        double average = (double) sum / favNum;
        System.out.println("Sum of first " + favNum + " numbers: " + sum);
        System.out.println("Average: " + average);
    }
}

public class GeneralTask {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = sc.nextLine();
        System.out.print("Enter your age: ");
        int age = sc.nextInt();
        System.out.print("Enter your favorite number: ");
        int favNum = sc.nextInt();

        General obj = new General();
        obj.greet(name, age);
        obj.processString(name);
        obj.printNumbers(favNum);
        obj.calculateSumAndAverage(favNum);

        sc.close();
    }
}
