package backend.challenge.service;

import backend.challenge.entities.request.CreateUserRequest;

public interface RequestValidator {

    void validate(CreateUserRequest request);
}
