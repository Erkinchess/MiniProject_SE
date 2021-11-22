package com.company;

// === DBManager === //
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class DBManager {
    private Connection cn;

    public void ConnectToDb(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Erkin?useUnicode=true&serverTimezone=UTC","root", "");
            System.out.println("Connected to DataBase");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void addStudentToDB(Student s){
        try {
            PreparedStatement ps = cn.prepareStatement("insert into students(name, surname, age) values(?,?,?)");
            ps.setString(1, s.getName());
            ps.setString(2, s.getSurname());
            ps.setInt(3, s.getAge());
            ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public ArrayList<Student> getAllStudents(){
        ArrayList<Student> students = new ArrayList<>();
        try {
            PreparedStatement ps = cn.prepareStatement("select * from Students");
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Long id = rs.getLong("id");
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                int age = rs.getInt("age");
                students.add(new Student(id, name, surname, age));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return students;
    }
}