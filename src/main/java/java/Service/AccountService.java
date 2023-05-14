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

    // public List<Account> getAllAccounts() {
    //     return this.accountDAO.getAllAccounts();
    // }

    public Account registerAccount(Account acc) {
        if (acc.password.length() > 3 && acc.username != "") {
            if (accountDAO.getAccountByUsername(acc.getUsername()) == null) {
                return this.accountDAO.insertAccount(acc);
            }
        }
        return null;
    }

    // public Account getAccountByUsername(Account acc) {

    //     return null;
    // }

    public Account loginAccount(Account acc) {
        return accountDAO.getAccountByUsernameAndPassword(acc.getUsername(), acc.getPassword());
    }
}