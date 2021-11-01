package backend.challenge.dao;

import backend.challenge.entities.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserDAO extends CrudRepository<User, UUID> {

    Optional<User> findByEmail (String email);
}
