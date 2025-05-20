package com.andrew.dao;

import com.andrew.model.Student;

public interface StudentDaoInterface {
    boolean insertStudent(Student s);
    boolean deleteStudent(int regNum);
    boolean updateStudent(int regNum, String update, int ch, Student stu);
    void showAllStudent();
    boolean getStudentByRegNum(int regnum);
}
