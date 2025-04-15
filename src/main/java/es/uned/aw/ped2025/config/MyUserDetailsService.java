package es.uned.aw.ped2025.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.uned.aw.ped2024.model.entities.Role;
import es.uned.aw.ped2024.model.entities.Usuario;
import es.uned.aw.ped2024.model.repository.UsuarioRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service("userDetailsService")
@Transactional
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UsuarioRepository userRepository;

    @Autowired
    private LoginAttemptService loginAttemptService;

    public MyUserDetailsService() {
        super();
    }

    // API

    @Override
    public UserDetails loadUserByUsername(final String email) throws UsernameNotFoundException {
        if (loginAttemptService.isBlocked()) {
            throw new RuntimeException("blocked");
        }

        try {
            final Usuario user = userRepository.findByEmail(email);
            if (user == null) {
                throw new UsernameNotFoundException("No user found with username: " + email);
            }

            return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), user.getEnabled(), true, true, true, getAuthorities(user.getRoles()));
        } catch (final Exception e) {
            throw new RuntimeException(e);
        }
    }

    private List<String> getPrivileges(final Collection<Role> roles) {
    	return roles.stream().map(Role::getNombre).collect(Collectors.toList());
    }

    private Collection<? extends GrantedAuthority> getAuthorities(final Collection<Role> roles) {
        return getGrantedAuthorities(getPrivileges(roles));
    }

    private List<GrantedAuthority> getGrantedAuthorities(final List<String> privileges) {
        final List<GrantedAuthority> authorities = new ArrayList<>();
        for (final String privilege : privileges) {
            authorities.add(new SimpleGrantedAuthority(privilege));
        }
        return authorities;
    }

}
