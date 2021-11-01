package backend.challenge.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "phone")
@Data
public class Phone {

    @Id
    private UUID phoneId;
    private UUID userId;
    private String number;
    private String citycode;
    private String contrycode;
}
