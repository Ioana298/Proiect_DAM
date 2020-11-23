package dam.tam4.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dam.tam4.domain.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
