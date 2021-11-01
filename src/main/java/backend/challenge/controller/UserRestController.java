package backend.challenge.controller;

import backend.challenge.entities.request.CreateUserRequest;
import backend.challenge.entities.response.CreateUserResponse;
import backend.challenge.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("BackEndChallenge/api/v1.0/user")
@Api(value = "user", tags = "UserOperations")
public class UserRestController {

    @Autowired
    private UserService userService;

    @Autowired
    private HttpHeaders headers;

    @ApiOperation(value = "Api para la creacion de nuevos usuarios",
            notes = "Completar todo los cambios requeridos a continuacion:",
            tags = {"UserOperations"})

    @PostMapping(headers = "Accept=application/json;charset=UTF-8")
    @ApiImplicitParam(name = "Authorization", value = "Access Token", required = true, paramType = "header", dataTypeClass = String.class, example = "Bearer access_token")
    public ResponseEntity<CreateUserResponse> createUser
            (@Valid @RequestBody CreateUserRequest request, @RequestHeader(value = "Authorization") String Authorization) {
        headers.clear();
        headers.set("Authorization", Authorization);
        CreateUserResponse response = userService.createUser(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
