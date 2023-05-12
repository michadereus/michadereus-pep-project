package DAO;

import Model.Message;
import Util.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/*
    message_id integer primary key auto_increment,
    posted_by integer,
    message_text varchar(255),
    time_posted_epoch long,
    foreign key (posted_by) references Account(account_id)

 */


public class MessageDAO {

    public List<Message> getAllMessages() {
        return null;
    }

    public Message getMessaegByMessageId(int messageID) {
        Connection connection = ConnectionUtil.getConnection();
        try {
            //Write SQL logic here
            String sql = "SELECT * FROM Message WHERE message_id = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            //write preparedStatement's setInt method here.
            preparedStatement.setInt(1, messageID);

            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                Message message = new Message(rs.getInt("message_id"),
                        rs.getInt("posted_by"),
                        rs.getString("message_text"),
                        rs.getLong("time_posted_epoch"));
                return message;
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    public Message insertMessage(Message message) {
        Connection connection = ConnectionUtil.getConnection();
        try {
            String sql = "INSERT INTO Message (message_id, posted_by, message_text, time_posted_epoch) VALUES (?, ?, ?, ?);";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, message.getMessage_id());
            preparedStatement.setInt(2, message.getPosted_by());
            preparedStatement.setString(3, message.getMessage_text());
            preparedStatement.setLong(4, message.getTime_posted_epoch());

            preparedStatement.executeUpdate();
            return message;

        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return null;
    }
    
}