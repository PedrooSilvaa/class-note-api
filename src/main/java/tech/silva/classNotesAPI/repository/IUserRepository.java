package tech.silva.classNotesAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.silva.classNotesAPI.entity.UserEntity;

import java.util.Optional;

public interface IUserRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findByUsername(String username);

}
