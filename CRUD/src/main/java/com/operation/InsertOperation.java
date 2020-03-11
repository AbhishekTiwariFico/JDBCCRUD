package com.operation;

import com.connection.ConnectionCreation;
import com.dataholder.DataContainer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertOperation extends Common{
    DataContainer data;
    public DataContainer getData()
    {
        Scanner scanner =new Scanner(System.in);

        System.out.println("Enter id of person");
        int id = scanner.nextInt();
        System.out.println("Enter age of person");
        int age = scanner.nextInt();
        System.out.println("Enter name of person");
        String  name = scanner.next();
        System.out.println("Enter state of person");
        String  state = scanner.next();
        System.out.println("Enter department of person");
        String  dept = scanner.next();
        System.out.println("Enter qualification of person");
        String  qual = scanner.next();
        data = new DataContainer(id,age,name,state,dept,qual);
        return data;
    }


    public void performOperation() throws SQLException, ClassNotFoundException {
        DataContainer data = getData();
        Connection connection = ConnectionCreation.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("insert into crud.information values(?,?,?,?,?,?)");
        preparedStatement.setInt(1, data.id);
        preparedStatement.setInt(2,data.age);
        preparedStatement.setString(3,data.name);
        preparedStatement.setString(4,data.state);
        preparedStatement.setString(5,data.department);
        preparedStatement.setString(6,data.qualification);
        int row = preparedStatement.executeUpdate();
        if(row>0)
            System.out.println("row inserted");



    }

    public void showResult() {

    }
}
