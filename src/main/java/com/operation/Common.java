package com.operation;

import com.dataholder.DataContainer;

import java.sql.SQLException;

abstract public class Common {
    abstract public DataContainer getData();
    abstract public void performOperation() throws SQLException, ClassNotFoundException;
    abstract public void showResult() throws SQLException;
}
