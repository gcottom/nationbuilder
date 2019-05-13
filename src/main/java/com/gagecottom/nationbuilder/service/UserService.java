package com.gagecottom.nationbuilder.service;

import com.gagecottom.nationbuilder.model.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
    
    void deleteAll();
}
