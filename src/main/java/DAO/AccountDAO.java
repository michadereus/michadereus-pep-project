package DAO;

import Model.Account;
import Util.ConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * A DAO is a class that mediates the transformation of data between the format of objects in Java to rows in a
 * database. The methods here are mostly filled out, you will just need to add a SQL statement.
 *
    account_id integer primary key auto_increment,
    username varchar(255),
    password varchar(255)
 *   
 */

public class AccountDAO{

    public List<Account> getAllAccounts(){
        Connection connection = ConnectionUtil.getConnection();
        List<Account> accounts = new ArrayList<>();
        return accounts;
    }

    public Account insertAccount(Account account) {
        return null;
    }



}