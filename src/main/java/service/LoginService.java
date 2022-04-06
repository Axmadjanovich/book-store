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
            System.out.print(bundle.getString("user.username"));
            String login = scanner.nextLine();
            System.out.print(bundle.getString("user.password"));
            String password = scanner.nextLine();

            User user = usersRepository.findUserByUsernameAndPassword(login, password);
            if (user != null) {
                Global.user = user;
                return true;
            }
            else {
                System.out.printf(bundle.getString("try.count")+"\n",2-count);
                count++;
            }
        }

        System.out.println(bundle.getString("registration"));
        int choice = scanner.nextInt();
        if (choice == 1) {
            scanner.nextLine();
            System.out.print(bundle.getString("first.name"));
            String firstName = scanner.nextLine();
            System.out.print(bundle.getString("last.name"));
            String lastName = scanner.nextLine();
            System.out.print(bundle.getString("phone.number"));
            String phone = scanner.nextLine();
            System.out.print(bundle.getString("user.name"));
            String username = scanner.nextLine();
            while (usersRepository.findUserByUsername(username) != null) {
                System.out.print(bundle.getString("username.not.found"));
                username = scanner.nextLine();
            }
            System.out.print(bundle.getString("password1"));
            String password1 = scanner.nextLine();
            System.out.print(bundle.getString("password2"));
            String password2 = scanner.nextLine();
            while (!password1.equals(password2)) {
                System.out.print(bundle.getString("password.not.equals"));
                password1 = scanner.nextLine();
                System.out.print(bundle.getString("password2"));
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