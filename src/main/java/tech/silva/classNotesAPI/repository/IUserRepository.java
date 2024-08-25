package tech.silva.classNotesAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.silva.classNotesAPI.entity.UserEntity;

public interface IUserRepository extends JpaRepository<UserEntity, Long> {

    UserEntity findByUserName(String username);

}
