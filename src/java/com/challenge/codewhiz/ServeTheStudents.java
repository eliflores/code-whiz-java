package com.challenge.codewhiz;

import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.stream.Collectors;

class Student {
    private int token;
    private String fname;
    private double cgpa;

    public Student(int id, String fname, double cgpa) {
        super();
        this.token = id;
        this.fname = fname;
        this.cgpa = cgpa;
    }

    public int getToken() {
        return token;
    }

    public String getFname() {
        return fname;
    }

    public double getCgpa() {
        return cgpa;
    }
}

public class ServeTheStudents {
    private static final Comparator<Student> STUDENT_COMPARATOR = (o1, o2) -> {
        int cgpaCompare = Double.compare(o2.getCgpa(), o1.getCgpa()); //Descending order
        if (cgpaCompare != 0) {
            return cgpaCompare;
        }

        int nameCompare = o1.getFname().compareTo(o2.getFname());
        if (nameCompare != 0) {
            return nameCompare;
        }

        return Integer.compare(o1.getToken(), o2.getToken());
    };

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int totalEvents = Integer.parseInt(in.nextLine());
        TreeSet<Student> students = new TreeSet<>(STUDENT_COMPARATOR);
        for (int i = 0; i < totalEvents; i++) {
            String event = in.next();

            if ("ENTER".equals(event)) {
                String name = in.next();
                double cgpa = in.nextDouble();
                int token = in.nextInt();
                Student student = new Student(token, name, cgpa);
                students.add(student);
            } else if ("SERVED".equals(event)) {
                if (!students.isEmpty()) {
                    students.pollFirst();
                }
            }
        }

        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            students.stream() //
                .map(Student::getFname) //
                .collect(Collectors.toList()) //
                .forEach(System.out::println);
        }
    }
}
