package com.main;

import com.operation.DeleteOperation;
import com.operation.InsertOperation;
import com.operation.ShowData;
import com.operation.UpdateOperation;

import java.sql.SQLException;
import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        int ch =0;
        do {

          System.out.println("Enter your choice\n 1 for insert in table\n 2 for update data\n 3 for show data \n 4 for delete \n5 for exit");
            Scanner sc = new Scanner(System.in);
            ch = sc.nextInt();
            switch(ch)
            {

                case 1:
                    InsertOperation io = new InsertOperation();
                    io.performOperation();
                    break;
                case 2:
                    UpdateOperation updateOperation = new UpdateOperation();
                    updateOperation.performOperation();
                    break;
                case 3:
                    ShowData showData = new ShowData();
                    showData.performOperation();
                      break;
                case 4:
                    DeleteOperation deleteOperation =new DeleteOperation();
                    deleteOperation.performOperation();
                    break;
                case 5: break;

                default:System.out.println("Enter Correct Choice");
            }
        }while(ch!=6);


    }
}
