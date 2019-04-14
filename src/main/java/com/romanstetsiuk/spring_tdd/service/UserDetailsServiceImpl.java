package com.romanstetsiuk.spring_tdd.service;

import com.romanstetsiuk.spring_tdd.model.User;
import com.romanstetsiuk.spring_tdd.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userRepository
                .findByUsername(s)
                .orElseThrow(EntityNotFoundException::new);

        UserDetails userDetails =
                new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), null);

        return userDetails;
    }
}
