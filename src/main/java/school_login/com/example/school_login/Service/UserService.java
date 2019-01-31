package school_login.com.example.school_login.Service;

import org.springframework.security.core.userdetails.UserDetailsService;
import school_login.com.example.school_login.model.User;

public interface UserService extends UserDetailsService {
    User findByUsername(String username);
}
