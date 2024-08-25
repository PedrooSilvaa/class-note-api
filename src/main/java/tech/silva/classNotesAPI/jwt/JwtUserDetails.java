package tech.silva.classNotesAPI.jwt;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import tech.silva.classNotesAPI.entity.UserEntity;

public class JwtUserDetails extends User {

    private UserEntity user;

    public JwtUserDetails(UserEntity user) {
        super(user.getUsername(), user.getPassword(), AuthorityUtils.createAuthorityList(user.getRole().name()));
        this.user = user;
    }

    public Long getId() {
        return this.user.getId();
    }

    public String getRole() {
        return this.user.getRole().name();
    }

}
