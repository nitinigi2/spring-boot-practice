package com.springboot.novoice.service;

import com.springboot.novoice.entity.User;
import com.springboot.novoice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public boolean delete(Long id) {
        Optional<User> optional = userRepository.findById(id);
        if(optional.isPresent()) {
            userRepository.delete(optional.get());
            return true;
        }
        return false;
    }

    public User update(User user) {
        Optional<User> optional = userRepository.findById(user.getId());
        if(optional.isPresent()) {
            userRepository.save(user);
            return user;
        }
        return null;
    }

    public User findUser(long id){
        Optional<User> optional = userRepository.findById(id);
        if(optional.isPresent()) {
            return optional.get();
        }
        return null;
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }
}
