import dao.User;
import dto.BookDTO;
import service.BookService;
import service.LoginService;

import java.util.Scanner;
import static helper.Global.*;

public class Main {
    private static final BookService bookService;
    private static final LoginService loginService;

    static {
        bookService = new BookService();
        loginService = new LoginService();
    }

    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);
        System.out.print("Usernameni kiriting: ");
        String login = scanner.nextLine();
        System.out.print("Parolni kiriting: ");
        String password = scanner.nextLine();
        if (loginService.login(login, password)) {

        }else {
            System.out.println("Username yoki parol xato");
        }
    }
}
