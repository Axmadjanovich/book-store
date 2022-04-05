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

    public boolean login(String login, String password){
        User user = usersRepository.findUserByUsernameAndPassword(login, password);
        if (user == null){
            return false;
        }else {
            Global.user = user;
        }
        return true;
    }


}
