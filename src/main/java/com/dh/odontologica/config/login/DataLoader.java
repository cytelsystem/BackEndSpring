package com.dh.odontologica.config.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    private UserRepository userRepository;


    //***************************************Constructores*******************************************//
    @Autowired
    public DataLoader(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    //****************************************Metodos*****************************************************//

    @Override
    public void run(ApplicationArguments args) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashepassword = passwordEncoder.encode("password");

        BCryptPasswordEncoder passwordEncoder2 = new BCryptPasswordEncoder();
        String hashepassword2 = passwordEncoder.encode("password2");

        userRepository.save(new AppUser("hector", "hectorjm", "hectorjaviermorenoh@gmail.com", hashepassword, AppUsuarioRoles.ADMIN));
        userRepository.save(new AppUser("carlos", "carlos2", "carlos@gmail.com", hashepassword2, AppUsuarioRoles.USER));
    }
    //****************************************************************************************************//
}
