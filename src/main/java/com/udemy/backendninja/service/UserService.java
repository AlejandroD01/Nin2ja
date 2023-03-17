package com.udemy.backendninja.service;

import com.udemy.backendninja.entity.UserRole;
import com.udemy.backendninja.repository.IRepositoryUser;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author ALE
 */
@Service("userService")
public class UserService implements UserDetailsService {

    @Autowired
    @Qualifier("iRepositoryUser")
    private IRepositoryUser iUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        com.udemy.backendninja.entity.User user = iUserRepository.findByUsername(username);
        List<GrantedAuthority> authoritys = buildAuthoritys(user.getUserRole());
        return buildUser(user, authoritys);
    }

    private User buildUser(com.udemy.backendninja.entity.User user, List<GrantedAuthority> authorities) {
        return new User(user.getUsername(), user.getPassword(), user.isEnable(),
                true, true, true, authorities);
    }

    private List<GrantedAuthority> buildAuthoritys(Set<UserRole> userRoles) {
        Set<GrantedAuthority> auths = new HashSet<GrantedAuthority>();
        for (UserRole userRole : userRoles) {
            auths.add(new SimpleGrantedAuthority(userRole.getRole()));
        }
        return new ArrayList<GrantedAuthority>(auths);
    }
}
