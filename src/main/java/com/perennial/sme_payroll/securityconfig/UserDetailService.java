package com.perennial.sme_payroll.securityconfig;

import com.perennial.sme_payroll.dao.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserDetailService implements UserDetailsService {

   /* @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user=userRepo.findByUsername(username);

        if(user==null)
            throw new UsernameNotFoundException("User not found.");

        return new UserDetailImpl(user);
    }
    */

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return new User("prashant","Prashant",new ArrayList<>());
    }
}
