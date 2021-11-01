package backend.challenge.entities.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class CreateUserPhoneRequestDTO {

    @ApiModelProperty(value = "Numero del usuario", position = 1, example = "1234567")
    private String number;

    @ApiModelProperty(value = "Codigo de ciudad del numero del usuario", position = 2, example = "1")
    private String citycode;

    @ApiModelProperty(value = "Codigo de pais del numero del usuario", position = 3, example = "57")
    private String contrycode;
}
