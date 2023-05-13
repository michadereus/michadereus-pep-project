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

    // public Message getMessaegByMessageId(int messageID) {
        
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

    public List<Message> getAllMessages() {
        return this.messageDAO.getAllMessages();
    }

}
