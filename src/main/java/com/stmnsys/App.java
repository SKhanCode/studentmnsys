package com.stmnsys;

import com.stmnsys.model.Student;
import com.stmnsys.service.StudentService;
import java.util.Scanner;

public class App {
  public static void main(String[] args) {
    StudentService svc = new StudentService();
    Scanner in = new Scanner(System.in);

    while (true) {
      System.out.print("""
          \n=== Student Management ===
          1) Add Student
          2) List All Students
          3) Find by ID
          4) Update Student
          5) Delete Student
          6) Exit
          Choose: """);

      int choice = in.nextInt();
      switch (choice) {
        case 1 -> {
          System.out.print("ID: ");
          int id = in.nextInt(); in.nextLine();
          System.out.print("Name: ");
          String name = in.nextLine();
          System.out.print("Age: ");
          int age = in.nextInt(); in.nextLine();
          System.out.print("Major: ");
          String major = in.nextLine();
          System.out.println(svc.add(new Student(id, name, age, major))
                             ? "Student added." : "ID already exists.");
        }
        case 2 -> svc.list().forEach(System.out::println);
        case 3 -> {
          System.out.print("Enter ID: ");
          Student s = svc.find(in.nextInt());
          System.out.println(s != null ? s : "Not found.");
        }
        case 4 -> {
          System.out.print("Enter ID: ");
          int id = in.nextInt(); in.nextLine();
          System.out.print("New Name: ");
          String name = in.nextLine();
          System.out.print("New Age: ");
          int age = in.nextInt(); in.nextLine();
          System.out.print("New Major: ");
          String major = in.nextLine();
          System.out.println(svc.update(id, name, age, major)
                             ? "Updated." : "Student not found.");
        }
        case 5 -> {
          System.out.print("Enter ID: ");
          System.out.println(svc.delete(in.nextInt())
                             ? "Deleted." : "Student not found.");
        }
        case 6 -> {
          System.out.println("Goodbye!");
          in.close();
          return;
        }
        default -> System.out.println("Invalid choice.");
      }
    }
  }
}
