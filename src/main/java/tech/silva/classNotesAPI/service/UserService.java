package tech.silva.classNotesAPI.service;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tech.silva.classNotesAPI.entity.UserEntity;
import tech.silva.classNotesAPI.exception.ObjectNotFoundException;
import tech.silva.classNotesAPI.exception.UserUniqueViolationException;
import tech.silva.classNotesAPI.repository.IUserRepository;

@AllArgsConstructor
@Service
public class UserService {

    private final IUserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public UserEntity saveUser(UserEntity user) {
        try {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            return userRepository.save(user);
        }catch (DataIntegrityViolationException ex){
            throw  new UserUniqueViolationException(String.format("User username: %s already exists", user.getUsername()));
        }
    }

    public UserEntity findByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(
                        () -> new ObjectNotFoundException(String.format("User username: %s not found", username))
                );
    }
}
