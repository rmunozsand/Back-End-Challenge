package backend.challenge.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "user")
@Data
public class User {

    @Id
    private UUID id;
    private String name;
    private String email;
    private String password;
    private Date created = new Date();
    private Date modified = new Date();
    private Date last_login = new Date();
    private String state = "ACTIVE";
}
