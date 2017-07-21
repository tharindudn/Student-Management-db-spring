package controller;

import model.Student;
import org.apache.log4j.Logger;
import repository.ExamRepository;
import repository.StudentRepository;
import repository.impl.ExamImpl;
import repository.impl.StudentImpl;
import studentmanagmentDB.Main;

import java.sql.SQLException;
import java.util.Scanner;

/**
 * Created by tharindu on 7/18/17.
 */
public class StudentControl {
    Logger logger = Logger.getLogger(Main.class);

    private StudentRepository studentRepository;
    private ExamRepository examRepository;
    Scanner in = new Scanner(System.in);


    int id;
    Student student = null;
    int result = 0;

    public StudentRepository getStudentRepository() {
        return studentRepository;
    }

    public void setStudentRepository(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public ExamRepository getExamRepository() {
        return examRepository;
    }

    public void setExamRepository(ExamRepository examRepository) {
        this.examRepository = examRepository;
    }

    public void addStudent() {
        Student newstudent = new Student();
        System.out.println("Enter student id : ");

        newstudent.setId(in.nextInt());
        System.out.println("Enter student name : ");

        newstudent.setName(in.next());
        result = 0;
        try {
            result = studentRepository.addstudentDetails(newstudent);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        if (result == 1) {
            System.out.println("data added...");
            logger.info("data added...");
        }

    }

    public void addMark() {
        System.out.println("Enter student id : ");
        logger.info("Enter student id : ");
        id = in.nextInt();
        try {
            student = studentRepository.checkStudent(id);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        if (student != null) {
            int[] marks = new int[2];

            System.out.println("Student exist...");
            logger.info("Student exist...");
            System.out.println("Enter marks for subject 1...");
            logger.info("Enter marks for subject 1...");
            marks[0] = in.nextInt();
            System.out.println("Enter marks for subject 2...");
            logger.info("Enter marks for subject 2...");
            marks[1] = in.nextInt();
            student.setMarks(marks);
            result = 0;
            try {
                result = studentRepository.addstudentMarks(student);
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            if (result == 1) {
                System.out.println("marks added...");
                logger.info("marks added...");
            }

        } else {
            System.out.println("No student with " + id);
            logger.info("No student with " + id);
        }
    }

    public void printMarks() {
        System.out.println("Enter student id to check marks: ");
        logger.info("Enter student id to check marks: ");
        id = in.nextInt();
        int[] marks = new int[2];
        try {
            marks = studentRepository.checkMarks(id);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        if (marks != null) {


            System.out.println("Student exist...");
            logger.info("Student exist...");

            System.out.println("NAME     | MARKS | GRADE  |");
            System.out.println("Subject1 | " + marks[0] + "    |  " + examRepository.grade(marks[0]) + "     |");
            System.out.println("Subject2 | " + marks[1] + "    |  " + examRepository.grade(marks[1]) + "     |");

        } else {
            System.out.println("No student with " + id);
            logger.info("No student with " + id);
        }
    }

    public void updateStudent() {
        System.out.println("Enter student id to update marks: ");

        id = in.nextInt();
        int[] marks = new int[2];
        System.out.println("Enter marks for sub 1: ");
        marks[0] = in.nextInt();
        System.out.println("Enter marks for sub 2: ");
        marks[1] = in.nextInt();
        student = new Student();
        student.setId(id);
        student.setMarks(marks);
        try {
            result = studentRepository.updatestudentMarks(student);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        if (result == 1) {
            System.out.println("updated...");
            logger.info("marks updated...");
        } else {
            System.out.println("Update fail..." + id);
            logger.info("Update fail..." + id);
        }

    }

    public void deletemarks() {
        System.out.println("Enter student id to Delete marks");
        id = in.nextInt();

        try {
            result = studentRepository.deletestudentMarks(id);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        if (result == 1) {
            System.out.println("deleted...");
            logger.info("marks deleted...");
        } else {
            System.out.println("Delete fail..." + id);
            logger.info("Delete fail..." + id);
        }
    }

}
