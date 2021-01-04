package com.example.demo.service;

import com.example.demo.model.AppUser;
import com.example.demo.model.AppUserDetail;
import com.example.demo.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser user = userRepository.findAllByUsername(username);
        if (user == null){
            throw new UsernameNotFoundException("User Not Found with username: " + username);
        }
        return new AppUserDetail(user);
    }

    public UserDetails loadUserById(Long id ){
        AppUser appUser = userRepository.findById(id).get();
        return new AppUserDetail(appUser);
    }
}
