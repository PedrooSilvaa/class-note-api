package tech.silva.classNotesAPI.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tech.silva.classNotesAPI.repository.IUserRepository;

@RequiredArgsConstructor
@Service
public class UserService {

    private final IUserRepository userRepository;

}
