package org.learning.springboot.service;

import org.learning.springboot.repositories.UserRepository;
import org.learning.springboot.schema.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service class for user to interact with database
 */
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

/*    private Map<Long, User> usersMap;

    public UserService() {
        usersMap = new HashMap<>();

        User user = new User();
        user.setId(1);
        user.setName("Leanne Graham");
        user.setUsername("Bret");
        user.setEmail("Sincere@april.biz");
        user.setPhone("1-770-736-8031 x56442");
        user.setWebsite("hildegard.org");


        Address address = new Address();
        address.setStreet("Kulas Light");
        address.setSuite("Apt. 556");
        address.setCity("Gwenborough");
        address.setZipcode("92998-3874");

        user.setAddress(address);

        Company company = new Company();
        company.setName("Romaguera-Crona");
        company.setCatchPhrase("Multi-layered client-server neural-net");
        company.setBusiness("harness real-time e-markets");

        user.setCompany(company);

        usersMap.put(1l, user);
    }*/

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User getUser(long id) {
        return userRepository.findById(id);
    }

    public User updateUser(User toBeUpdated) throws UserNotFoundException {
        User user = userRepository.findById(toBeUpdated.getId());
        if (user == null) {
            throw new UserNotFoundException(toBeUpdated.getId());
        }
        return userRepository.save(toBeUpdated);
    }

    public String deleteUser(long id) throws UserNotFoundException {
        if (userRepository.findById(id) != null) {
            userRepository.delete(id);
            return "Deleted user with id: " + id;
        }
        throw new UserNotFoundException(id);
    }

    public User createUser(User newUser) {
        return userRepository.save(newUser);
    }
}
