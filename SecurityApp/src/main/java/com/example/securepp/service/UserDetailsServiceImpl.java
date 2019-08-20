package com.example.securepp.service;

import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.securepp.model.User;
import com.example.securepp.repo.UserRepo;
import com.example.securepp.repoImpl.UserImplemetClass;

@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepo userepo;

    @Transactional(readOnly = true)
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            User user =  userepo.findByUsername(username); 
            
            if(user== null) throw new
             UsernameNotFoundException("User 404");
     
            return new UserImplemetClass(userepo.findByUsername(username));
            
            
        } catch (NoSuchElementException e) {
            throw new UsernameNotFoundException("User " + username + " not found.", e);
        }
    }

}