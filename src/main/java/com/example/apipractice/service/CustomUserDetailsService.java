package com.example.apipractice.service;

import com.example.apipractice.model.CustomUserDetails;
import com.example.apipractice.model.User;
import com.example.apipractice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepo;

    public User getUserByPrincipal(Principal principal){
        Optional<User> user = userRepo.findByUsername(principal.getName());
        user.orElseThrow(() -> new UsernameNotFoundException( "User not found."));
        return user.get();

    }

//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        return null;
//    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepo.findByUsername(username);
        user.orElseThrow(() -> new UsernameNotFoundException(username + " not found."));

        return user.map(CustomUserDetails::new).get();


    }
}
