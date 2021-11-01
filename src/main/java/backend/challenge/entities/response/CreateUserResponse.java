package backend.challenge.entities.response;

import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
public class CreateUserResponse {

    private UUID id;
    private Date created;
    private Date modified;
    private Date last_login;
    private String token;
    private boolean isActive;
}
