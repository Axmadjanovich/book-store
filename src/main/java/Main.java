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
        if (loginService.login()) {
            System.out.println("Tilni tanlang: \n1. Uz \n2. Ru");
            lang = scanner.nextInt() == 2 ? "ru" : "uz";

            if (lang.equals("uz")) {
                System.out.print("Kitob ID sini kiriting: ");
            } else {
                System.out.println("Введите ID вашей книги");
            }
            int id = scanner.nextInt();
            BookDTO bookDTO = bookService.getBookById(id, lang);
            System.out.println(bookDTO == null ? (lang.equals("uz") ? "Bunday kitob topilmadi" : "книга не найдена") : bookDTO);

        }

    }
}
