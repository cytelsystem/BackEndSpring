package com.dh.odontologica.service;

import com.dh.odontologica.config.login.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.HashSet;
//import java.util.Set;
//
//@Service
//@Transactional
//public class UserDetailsServiceImpl implements UserDetailsService {
//
//    @Autowired
//    UserRepository userRepository;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//
//        Usuario appUser = userRepository.findByUsername(username);
//
//        Set<GrantedAuthority> grantList = new HashSet<GrantedAuthority>();
//        for (Rol rol: appUser.getRoles()) {
//            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(rol.getDescription());
//            grantList.add(grantedAuthority);
//        }
//        UserDetails user = null;
//        user = (UserDetails) new User(username,"{noop}" + appUser.getPassword(), grantList);
//
//        return user;
//    }
//}
