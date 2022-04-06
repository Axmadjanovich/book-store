import dto.BookDTO;
import service.BookService;
import service.LoginService;

import java.util.Locale;
import java.util.ResourceBundle;
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
        System.out.println("Tilni tanlang: 1. O'zbekcha   2. Inglizcha\n" +
                "Choose a language: 1. Uzbek   2. English");
        int lang = scanner.nextInt();
        scanner.nextLine();
        if(lang == 1){
            locale = new Locale("uz", "UZ");
        }else{
            locale = new Locale("en", "US");
        }
        bundle = ResourceBundle.getBundle("message",locale);

        System.out.println(bundle.getString("welcome"));

        if(loginService.login()){

            System.out.println(bundle.getString("book.enter"));
            int id = scanner.nextInt();
            BookDTO bookDTO = bookService.getBookById(id);
            System.out.println(bookDTO == null  ? (bundle.getString("book.not.found")): bookDTO);
        }
    }
}
