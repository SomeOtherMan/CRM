package by.kustarev.crm.service;

import by.kustarev.crm.model.User;
import by.kustarev.crm.repository.UserRepository;

public class CheckAuthService {

    public static User getUserByLoginAndPassword(String login, String password) {
        return UserRepository.getUserByLoginAndPassword(login, password);
    }

}
