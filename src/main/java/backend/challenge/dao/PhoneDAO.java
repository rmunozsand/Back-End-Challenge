package backend.challenge.dao;

import backend.challenge.entities.Phone;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface PhoneDAO extends CrudRepository<Phone, UUID> {
}
