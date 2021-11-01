package backend.challenge.entities.response;

import lombok.Data;

@Data
public class JwtTokenResponse
{
    private final String token;

    public JwtTokenResponse(String token) {
        this.token = token;
    }

    public String getToken() {
        return this.token;
    }
}
