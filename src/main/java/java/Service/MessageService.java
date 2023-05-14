package Service;
import Model.Message;
import java.util.List;
import DAO.MessageDAO;
import DAO.AccountDAO;

public class MessageService {
    private MessageDAO messageDAO;

    public MessageService(){
        messageDAO = new MessageDAO();
    }

    public MessageService(MessageDAO MessageDAO){
        this.messageDAO = MessageDAO;
    }

    // public Message getMessageByMessageId(int messageID) {
        
    // }
    /*
     * The creation of the message will be successful if and only if the message_text is not blank, is under 255 characters, and posted_by refers to a real, existing user. 
     * If successful, the response body should contain a JSON of the message, including its message_id. 
     * The response status should be 200, which is the default. The new message should be persisted to the database.
     */

    public Message createMessage(Message message) {
        AccountDAO accountDAO = new AccountDAO();

        if (message.getMessage_text().length() < 255 && message.getMessage_text() != "") {
            if (accountDAO.getAccountByID(message.getPosted_by()) != null) {
                return this.messageDAO.insertMessage(message);
            }
        }
        return null;
    }

    public Message patchMessageByMessageID(String messageID, String new_text) {
        int messageID_int = Integer.valueOf(messageID);
        Message message = this.messageDAO.getMessageByMessageID(messageID_int);
        String new_text_2 = new_text.split(":")[1];
        new_text_2 = new_text_2.replaceAll("\"|}", "").stripLeading().stripTrailing();
         
        if (message != null && new_text_2.length() <= 255 && new_text_2 != "") {
            this.messageDAO.updateMessageByMessageID(messageID_int, new_text_2);
            return this.messageDAO.getMessageByMessageID(messageID_int);
        }
        return null;
    }

    public Message getMessageByID(String messageID) {
        int messageID_int = Integer.valueOf(messageID);
        return this.messageDAO.getMessageByMessageID(messageID_int);
    }

    public List<Message> getAllMessages() {
        return this.messageDAO.getAllMessages();
    }

    public Message delMessageByID(String messageID) {
        int messageID_int = Integer.valueOf(messageID);
        Message getMessage = this.messageDAO.getMessageByMessageID(messageID_int);
        if (getMessage != null) {
            this.messageDAO.delMessageByMessageID(messageID_int);
        } 
        return getMessage;
    }

    public List<Message> getAllMessagesByAccountID(String accountID) {
        int accountID_int = Integer.valueOf(accountID);
        return this.messageDAO.getMessagesByAccountID(accountID_int);
    }

}
