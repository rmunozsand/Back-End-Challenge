package backend.challenge.entities.request;

import io.swagger.annotations.ApiModelProperty;

public class JwtTokenRequest {

    @ApiModelProperty(value = "Nombre de usuario", position = 1, example = "admin")
    private String username;

    @ApiModelProperty(value = "Clave de usuario", position = 2, example = "123")
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
