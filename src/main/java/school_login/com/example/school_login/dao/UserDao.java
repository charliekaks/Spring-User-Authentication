package school_login.com.example.school_login.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import school_login.com.example.school_login.model.User;

@Repository
public interface UserDao extends CrudRepository <User,Long> {
    User findByUsername (String username);
}
