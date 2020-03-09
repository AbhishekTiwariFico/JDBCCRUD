package com.operation;

import com.connection.ConnectionCreation;
import com.dataholder.DataContainer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ShowData extends Common {

    ResultSet resultSet;
    public DataContainer getData() {
        return null;
    }

    public void performOperation() throws SQLException, ClassNotFoundException {

        Connection connection = ConnectionCreation.getConnection();
       PreparedStatement preparedStatement =  connection.prepareStatement("select * from crud.information where id=?");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter id to get your data");
        int id =scanner.nextInt();
        preparedStatement.setInt(1,id);
        resultSet = preparedStatement.executeQuery();
        if(resultSet != null)
         showResult();
        else
        {
            System.out.println("Data not available");
        }
    }

    public void showResult() throws SQLException {

        while(resultSet.next())
        {
            System.out.println("ID="+resultSet.getInt(1)+" \nAGE="+resultSet.getInt(2)+" \nNAME="+resultSet.getString(3)+" \nSTATE="+resultSet.getString(4)+" \nDEPARTMENT="+resultSet.getString(5)+" \nQUALIFICATION="+resultSet.getString(6));
        }

    }
}
