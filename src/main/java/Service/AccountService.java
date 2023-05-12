package Service;
import Model.Account;
import java.util.List;
import DAO.AccountDAO;

public class AccountService {
    private AccountDAO accountDAO; 

    public AccountService(){
        accountDAO = new AccountDAO();
    }

    public AccountService(AccountDAO accountDAO){
        this.accountDAO = accountDAO;
    }

    public List<Account> getAllAccounts() {
        return this.accountDAO.getAllAccounts();
    }

    public Account addAuthor(Account account) {
        return this.accountDAO.insertAccount(account);
    }

}