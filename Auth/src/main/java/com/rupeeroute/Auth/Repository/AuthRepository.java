package com.rupeeroute.Auth.Repository;

import com.rupeeroute.Auth.Model.User;
import org.apache.el.stream.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthRepository extends JpaRepository<User, Long>
{

    User findByUsername(String username);
}
