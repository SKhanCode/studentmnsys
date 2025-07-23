package com.stmnsys.service;

import com.stmnsys.model.Student;
import java.io.*;
import java.util.*;

public class StudentService {
  private static final String DATA_FILE = "src/main/resources/data/students.dat";
  private Map<Integer, Student> students = new TreeMap<>();

  public StudentService() {
    loadFromFile();
  }

  public boolean add(Student s) {
    if (students.containsKey(s.id())) return false;
    students.put(s.id(), s);
    saveToFile();
    return true;
  }

  public Collection<Student> list() {
    return students.values();
  }

  public Student find(int id) {
    return students.get(id);
  }

  public boolean update(int id, String name, int age, String major) {
    if (!students.containsKey(id)) return false;
    students.put(id, new Student(id, name, age, major));
    saveToFile();
    return true;
  }

  public boolean delete(int id) {
    if (students.remove(id) == null) return false;
    saveToFile();
    return true;
  }

  @SuppressWarnings("unchecked")
  private void loadFromFile() {
    File file = new File(DATA_FILE);
    if (!file.exists()) return;
    try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
      students = (Map<Integer, Student>) in.readObject();
    } catch (Exception e) {
      students.clear();
    }
  }

  private void saveToFile() {
    File file = new File(DATA_FILE);
    file.getParentFile().mkdirs();
    try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file))) {
      out.writeObject(students);
    } catch (IOException e) {
      System.err.println("Error saving data: " + e.getMessage());
    }
  }
}
