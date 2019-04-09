package nationbuilder.service;

import nationbuilder.model.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}
