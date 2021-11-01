package backend.challenge.service;

import backend.challenge.entities.request.CreateUserRequest;
import backend.challenge.entities.response.CreateUserResponse;

public interface UserService {
    CreateUserResponse createUser(CreateUserRequest request);
}
