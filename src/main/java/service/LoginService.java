package service;

import dao.User;
import db.UsersRepository;
import helper.Global;

import static helper.Global.*;

public class LoginService {

    private final UsersRepository usersRepository;

    public LoginService(){
        usersRepository = new UsersRepository();
    }

    public boolean login(){
        int count = 0;
        while (count< 3) {
            System.out.print("Usernameni kiriting: ");
            String login = scanner.nextLine();
            System.out.print("Parolni kiriting: ");
            String password = scanner.nextLine();

            User user = usersRepository.findUserByUsernameAndPassword(login, password);
            if (user != null) {
                Global.user = user;
                return true;
            }
            else {
                System.out.println("Parol yoki username noto'g'ri. Qaytadan kiriting, " + (2-count) + " ta urinish qoldi");
                count++;
            }
        }

        System.out.println("Registratsiyadan o'tasizmi? 1. Ha, 2. Yo'q");
        int choice = scanner.nextInt();
        if (choice == 1) {
            scanner.nextLine();
            System.out.print("Ismingizni kiriting: ");
            String firstName = scanner.nextLine();
            System.out.print("Familyangizni kiriting: ");
            String lastName = scanner.nextLine();
            System.out.println("Tel. raqamingiz kiriting: ");
            String phone = scanner.nextLine();
            System.out.println("Username kiriting: ");
            String username = scanner.nextLine();
            while (usersRepository.findUserByUsername(username) != null) {
                System.out.println("Username allaqachon kiritilgan. Iltimos, boshqa username kiriting: ");
            }
            System.out.println("Password kiriting: ");
            String password1 = scanner.nextLine();
            System.out.println("Passwordni tasdiqlang: ");
            String password2 = scanner.nextLine();
            while (!password1.equals(password2)) {
                System.out.println("Passwordlar mos kelmayapti. Iltimos, qaytadan kiriting: ");
                password1 = scanner.nextLine();
                System.out.println("Passwordni tasdiqlang: ");
                password2 = scanner.nextLine();
            }
            User user = new User(firstName, lastName, phone,  password1, username);
            Global.user = usersRepository.addUser(user);
            return true;
        }else {
            return false;
        }

    }
}