package Service;
import Model.Message;
import java.util.List;
import DAO.MessageDAO;

public class MessageService {
    private MessageDAO messageDAO;

    public MessageService(){
        messageDAO = new MessageDAO();
    }

    public MessageService(MessageDAO MessageDAO){
        this.messageDAO = MessageDAO;
    }

    public List<Message> getAllAccounts() {
        return this.messageDAO.getAllMessages();
    }

    public Message addAuthor(Message message) {
        return this.messageDAO.insertMessage(message);
    }

}
