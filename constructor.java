class Student {
    String name;
    int age;
    double grade;

    Student() {
        this.name = "Default Name";
        this.age = 18;
        this.grade = 0.0;
    }

    Student(String name, int age, double grade) {
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    Student(Student s) {
        this.name = s.name;
        this.age = s.age;
        this.grade = s.grade;
    }

    void display() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Grade: " + grade);
        System.out.println();
    }
}

public class constructor {
    public static void main(String[] args) {
        Student s1 = new Student();
        System.out.println("Student 1 Details:");
        s1.display();

        Student s2 = new Student("Alex", 20, 85.5);
        System.out.println("Student 2 Details:");
        s2.display();

        Student s3 = new Student(s2);
        System.out.println("Student 3 (Copy of Student 2) Details:");
        s3.display();
    }
}
