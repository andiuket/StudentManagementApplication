package com.andrew.dao;

import com.andrew.db.DBConnection;
import com.andrew.model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class StudentDaoImpl implements StudentDaoInterface{
    @Override
    public boolean insertStudent(Student s) {
        boolean flag = false;
        try (Connection con = DBConnection.createConnection())
        {
            String query = "INSERT INTO public.student_details(name, collegename, city, percentage) values (?, ?, ?, ?)";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, s.getName());
            pst.setString(2, s.getCollegeName());
            pst.setString(3, s.getCity());
            pst.setDouble(4, s.getPercentage());

            pst.executeUpdate();
            flag=true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public boolean deleteStudent(int regNum) {
        boolean flag = false;
        try(Connection con = DBConnection.createConnection()){
            String query = "DELETE FROM student_details WHERE regnum =" +regNum;
            PreparedStatement pst = con.prepareStatement(query);
            pst.executeUpdate();
            flag = true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public boolean updateStudent(int regNum, String update, int ch, Student stu) {
        boolean flag = false;

        try
        {
            if(ch==1){
                Connection con = DBConnection.createConnection();
                String query = "UPDATE student_details SET ";
                PreparedStatement pst = con.prepareStatement(query);
                pst.setString(1, update);
                pst.setInt(2, regNum);
                pst.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public void showAllStudent() {
        boolean flag = false;
        try(Connection con = DBConnection.createConnection()){
            String query = "SELECT * FROM student_details";
            Statement stmt = con.createStatement();
            ResultSet st = stmt.executeQuery(query);
            while (st.next()){
                System.out.println("RegNum: " + st.getInt(1) +
                        "\nName: " + st.getString(2) +
                        "\nCollegeName: " + st.getString(3) +
                        "\nCity: " + st.getString(4) +
                        "\nPercentage: " + st.getDouble(5));

                System.out.println("--------------------------------");

                flag = true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public boolean getStudentByRegNum(int regnum) {
        boolean flag = false;
        try(Connection con = DBConnection.createConnection()){
            String query = "SELECT * FROM student_details WHERE regnum =" +regnum;
            Statement stmt = con.createStatement();
            ResultSet st = stmt.executeQuery(query);
            while (st.next()){
                System.out.println("RegNum: " + st.getInt(1) +
                        "\nName: " + st.getString(2) +
                        "\nCollegeName: " + st.getString(3) +
                        "\nCity: " + st.getString(4) +
                        "\nPercentage: " + st.getDouble(5));

                System.out.println("--------------------------------");
                flag = true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }
}
