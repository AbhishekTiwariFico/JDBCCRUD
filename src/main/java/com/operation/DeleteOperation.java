package com.operation;

import com.connection.ConnectionCreation;
import com.dataholder.DataContainer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DeleteOperation extends  Common {
    int count;

    public DataContainer getData() {

        return null;
    }

    public void performOperation() throws SQLException, ClassNotFoundException {
        Connection connection = ConnectionCreation.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("delete from crud.information where id =?");
        Scanner scanner =new Scanner(System.in);
        System.out.println("enter id for which you want to delete data");
        int id =  scanner.nextInt();

        preparedStatement.setInt(1,id);
        count = preparedStatement.executeUpdate();
        showResult();
    }

    public void showResult() {
        if(count > 0)
            System.out.println("Data deleted successfully ");
        else
            System.out.println("ID data is not available in database");

    }
}
