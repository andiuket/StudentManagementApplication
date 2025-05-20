package com.andrew.main;

import com.andrew.dao.StudentDaoImpl;
import com.andrew.dao.StudentDaoInterface;
import com.andrew.model.Student;

import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        StudentDaoInterface studentDaoInterface = new StudentDaoImpl();
        System.out.println("Welcome to Student Management Application");
        Scanner sc = new Scanner(System.in);
        while (true){

            System.out.println(
                    """
                            
                            1. Add Student\
                            
                            2. Show All Student\
                            
                            3. Get Student by regNum\
                            
                            4. Delete Student\
                            
                            5. Update Student\
                            
                            6. Exit Application""");

            System.out.println("Make Your Choice");
            int choice = sc.nextInt();
            switch (choice){
                case 1:
                    System.out.println("Add A Student");
                    System.out.print("Enter name: ");
                    String name = sc.next();
                    System.out.print("Enter CollegeName: ");
                    String collegeName = sc.next();
                    System.out.print("Enter City Name: ");
                    String city = sc.next();
                    System.out.print("Enter percentage: ");
                    double percentage = sc.nextDouble();
                    Student st = new Student(name, collegeName, city, percentage);
                    boolean ans = studentDaoInterface.insertStudent(st);
                    if(ans){
                        System.out.println("Add Student to the DB successfully!!!");
                    }else
                        System.out.println("Something went wrong please try again");
                    break;
                case 2:
                    System.out.println("Show All Student");
                    studentDaoInterface.showAllStudent();
                    break;
                case 3:
                    System.out.println("Get Student By regNum");
                    System.out.print("Enter RegNum: ");
                    int rn = sc.nextInt();
                    boolean isExisting = studentDaoInterface.getStudentByRegNum(rn);
                    if (!isExisting){
                        System.out.println("Student with this ID not available in our System");
                    }
                    break;
                case 4:
                    System.out.println("Deleting Student");
                    System.out.println("Entering Roll Number to be Deleted");
                    int regNum = sc.nextInt();
                    boolean isDeleted = studentDaoInterface.deleteStudent(regNum);
                    if(isDeleted){
                        System.out.println("Record deleted Successfully");
                    }else {
                        System.out.println("Something went Wrong");
                    }
                    break;
                case 5:
                    System.out.println("Update Student");
                    System.out.println("\n1. Update Name\n2. Update the City");
                    System.out.print("Enter Your Choice: ");
                    int ch = sc.nextInt();
                    if(ch==1) {
                        System.out.print("Enter Reg num: ");
                        int regn = sc.nextInt();
                        System.out.print("Enter New Name: ");
                        String nm = sc.next();
                        Student std = new Student();
                        std.setName(nm);
                        boolean flag = studentDaoInterface.updateStudent(regn, nm, ch, std);
                        if (flag) {
                            System.out.println("Name Updated Successfully!!!");
                        } else
                            System.out.println("Something went Wrong...");
                    }
                    break;
                case 6:
                    System.out.println("Exiting Application");
                    System.exit(0);
                default:
                    System.out.println("Enter valid choice");
            }
        }
    }
}
