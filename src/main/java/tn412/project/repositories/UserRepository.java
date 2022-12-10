package tn412.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn412.project.models.User;

public interface UserRepository extends JpaRepository<User, Long> {

//    @Query("SELECT 1 FROM user u WHERE u.email = ?1")
    public User findByEmail(String email);

//    Optional<User> findByEmail(String email);

}
