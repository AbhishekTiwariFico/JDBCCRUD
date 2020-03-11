package com.operation;

import com.connection.ConnectionCreation;
import com.dataholder.DataContainer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdateOperation extends Common {

   DataContainer data;
    int count;
    public DataContainer getData() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Id for which you wants to update data");
        int id = sc.nextInt();
        System.out.println("enter updated age");
        int age = sc.nextInt();
        System.out.println("Enter updated name");
        String name = sc.next();
        System.out.println("Enter updated State");
        String state = sc.next();
        System.out.println("Enter updated department");
        String department = sc.next();
        System.out.println("Enter updated qualification");
        String qualification = sc.next();
        data = new DataContainer(id,age,name,state,department,qualification);
        return data;
    }

    public void performOperation() throws SQLException, ClassNotFoundException {
        Connection connection = ConnectionCreation.getConnection();
        data = getData();
        PreparedStatement preparedStatement =  connection.prepareStatement("UPDATE crud.information SET age=?,name=?,state=?,department=?,qualification=? where id=?");
        preparedStatement.setInt(1,data.age);
        preparedStatement.setString(2,data.name);
        preparedStatement.setString(3,data.state);
        preparedStatement.setString(4,data.department);
        preparedStatement.setString(5,data.qualification);
        preparedStatement.setInt(6,data.id);
        count = preparedStatement.executeUpdate();
        showResult();

    }

    public void showResult() {
        if(count>0)
            System.out.println("Your data is updated");
        else
        {
            System.out.println("Data is not updated plz try again");
        }
    }
}
