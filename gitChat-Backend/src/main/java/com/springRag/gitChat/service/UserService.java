package com.springRag.gitChat.service;

import com.springRag.gitChat.entity.User;
import com.springRag.gitChat.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.encrypt.TextEncryptor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final TextEncryptor tokenEncryptor;

    @Transactional
    public User findById(UUID id)
    {
        return userRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("User with id " + id + " not found"));
    }

    public String decryptAccessToken(User user)
    {
        return tokenEncryptor.decrypt(user.getAccessToken());
    }

    private static Long toLong(Object value)
    {
        if (value instanceof Number number)
        {
            return number.longValue();
        }
        return Long.parseLong(String.valueOf(value));

    }

}
