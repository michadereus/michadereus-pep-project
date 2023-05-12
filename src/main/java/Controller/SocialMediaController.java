package Controller;

import io.javalin.Javalin;
import io.javalin.http.Context;

import Service.MessageService;
import Service.AccountService;
import Model.Account;
import Model.Message;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.javalin.Javalin;
import io.javalin.http.Context;

/**
 * TODO: You will need to write your own endpoints and handlers for your controller. The endpoints you will need can be
 * found in readme.md as well as the test cases. You should
 * refer to prior mini-project labs and lecture materials for guidance on how a controller may be built.
 */
public class SocialMediaController {
    MessageService messageService;
    AccountService accountService;

    public SocialMediaController(){
        this.messageService = new MessageService();
        this.accountService = new AccountService();
    }

    /**
     * In order for the test cases to work, you will need to write the endpoints in the startAPI() method, as the test
     * suite must receive a Javalin object from this method.
     * @return a Javalin app object which defines the behavior of the Javalin controller.
     */
    public Javalin startAPI() {
        // Javalin app = Javalin.create();
        // app.get("/books", this::getAllBooksHandler);
        // app.post("/books", this::postBookHandler);
        // app.get("/authors", this::getAllAuthorsHandler);
        // app.post("/authors", this::postAuthorHandler);
        // app.get("/books/available", this::getAvailableBooksHandler);
        // app.start(8080);
        Javalin app = Javalin.create();
        app.post("/messages", this::postMessageHandler);
        // app.start(8080);
        return app;
    }

    private void postMessageHandler(Context context) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        Message message = mapper.readValue(context.body(), Message.class);
        Message addedmessage = messageService.createMessage(message);
        if(addedmessage!=null){
            context.json(mapper.writeValueAsString(addedmessage));
        }else{
            context.status(400);
        }
    }


}