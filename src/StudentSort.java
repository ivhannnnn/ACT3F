import java.util.Scanner;

class Student {
    String name;
    double grade;

 
    public Student(String name, double grade) {
        this.name = name;
        this.grade = grade;
    }
    @Override
    public String toString() {
        return name + " - " + grade;
    }
}
public class StudentSort {
    public static void bubbleSort(Student[] students) {
        int n = students.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (students[j].grade > students[j + 1].grade) {
                  
                    Student temp = students[j];
                    students[j] = students[j + 1];
                    students[j + 1] = temp;
                }
            }
        }
    }
    public static void selectionSort(Student[] students) {
        int n = students.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (students[j].grade < students[minIndex].grade) {
                    minIndex = j;
                }
            }
            Student temp = students[i];
            students[i] = students[minIndex];
            students[minIndex] = temp;
        }
    }
    public static void insertionSort(Student[] students) {
        int n = students.length;
        for (int i = 1; i < n; i++) {
            Student key = students[i];
            int j = i - 1;
            while (j >= 0 && students[j].grade > key.grade) {
                students[j + 1] = students[j];
                j--;
            }
            students[j + 1] = key;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("How many students? ");
        int numStudents = scanner.nextInt();
        scanner.nextLine(); 

        Student[] students = new Student[numStudents];

        for (int i = 0; i < numStudents; i++) {
            System.out.println("Enter details for student #" + (i + 1));
            System.out.print("Name: ");
            String name = scanner.nextLine();
            System.out.print("Grade: ");
            double grade = scanner.nextDouble();
            scanner.nextLine(); 
            students[i] = new Student(name, grade);
        }
        System.out.println("\nChoose a sorting algorithm:");
        System.out.println("1 - Bubble Sort");
        System.out.println("2 - Selection Sort");
        System.out.println("3 - Insertion Sort");
        System.out.print("Enter choice (1-3): ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                bubbleSort(students);
                break;
            case 2:
                selectionSort(students);
                break;
            case 3:
                insertionSort(students);
                break;
            default:
                System.out.println("Invalid choice. Using Bubble Sort by default.");
                bubbleSort(students);
        }
        System.out.println("\nSorted Students by Grade (Ascending):");
        for (Student student : students) {
            System.out.println(student);
        }

        scanner.close();
    }
}









