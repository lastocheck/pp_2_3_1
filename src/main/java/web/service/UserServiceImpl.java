package web.service;

import org.springframework.stereotype.Component;
import web.model.ContactInfo;
import web.model.User;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserServiceImpl implements UserService {

    private List<User> users;
    private int count = 0;

    {
        users = new ArrayList<>();
        users.add(new User(++count, "username1", new ContactInfo("email1", "phone1")));
        users.add(new User(++count, "username2", new ContactInfo("email2", "phone2")));
        users.add(new User(++count, "username3", new ContactInfo("email3", "phone3")));
    }

    @Override
    public void save(User user) {
        if (user.getId() == 0) {
            user.setId(++count);
        }
        users.add(user);
    }

    @Override
    public void delete(int id) {
        users.removeIf(user -> user.getId() == id);
    }

    @Override
    public void update(User newUser) {
        User userToUpdate = findById(newUser.getId());
        userToUpdate.setUsername(newUser.getUsername());
        userToUpdate.setContactInfo(newUser.getContactInfo());
    }

    @Override
    public User findById(int id) {
        return users.stream()
                .filter(user -> user.getId() == id)
                .findFirst().get();
    }

    @Override
    public List<User> getAllUsers() {
        return users;
    }
}
