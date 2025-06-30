package com.mywork.boot.user.service;

import com.mywork.boot.user.dto.SiteUser;
import com.mywork.boot.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public SiteUser create(String userName, String password, String email){
        SiteUser siteUser = new SiteUser();

        siteUser.setUsername(userName);
        siteUser.setEmail(email);
        siteUser.setPassword(passwordEncoder.encode(password));

        this.userRepository.save(siteUser);

        return siteUser;
    }
}
