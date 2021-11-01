package backend.challenge.entities.request;

import backend.challenge.entities.dto.CreateUserPhoneRequestDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class CreateUserRequest {

        @ApiModelProperty(value = "Nombre del usuario", position = 1, example = "Juan Rodriguez")
        private String name;

        @ApiModelProperty(value = "Email del usuario", position = 2, example = "juan@rodriguez.org")
        private String email;

        @ApiModelProperty(value = "Clave del usuario", position = 3, example = "AAAbbbccc@123")
        private String password;

        @ApiModelProperty(value = "Datos de telefono", position = 4)
        private List<CreateUserPhoneRequestDTO> phones;
}
