import java.util.Scanner;

public class Arrays{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] arr = new int[5];
        System.out.println("Enter 5 numbers:");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("\nArray Elements using for loop:");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.println("\nArray Elements using enhanced for-loop:");
        for (int num : arr) {
            System.out.print(num + " ");
        }

        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        double average = (double) sum / arr.length;
        System.out.println("\n\nSum: " + sum);
        System.out.println("Average: " + average);

        java.util.Arrays.sort(arr);
        System.out.println("\nSorted Array: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }

        System.out.print("\nEnter a number to search: ");
        int key = sc.nextInt();
        boolean found = false;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                System.out.println(key + " found at index " + i);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println(key + " not found in the array.");
        }

        System.out.println("\n2D Array (3x3 Matrix):");
        int[][] matrix = new int[3][3];
        int value = 1;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matrix[i][j] = value++;
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        sc.close();
    }
}
