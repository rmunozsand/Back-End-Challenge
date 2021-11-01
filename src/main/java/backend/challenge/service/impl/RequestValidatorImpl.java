package backend.challenge.service.impl;

import backend.challenge.exception.BusinessException;
import backend.challenge.dao.UserDAO;
import backend.challenge.entities.User;
import backend.challenge.entities.dto.CreateUserPhoneRequestDTO;
import backend.challenge.entities.request.CreateUserRequest;
import backend.challenge.exception.RequestException;
import backend.challenge.service.RequestValidator;
import backend.challenge.service.util.ValidateUtils;
import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class RequestValidatorImpl implements RequestValidator {

    @Autowired
    private UserDAO userDAO;

    @Value("${password.user.pattern}")
    String passwordPatern;

    @Value("${password.user.pattern.invalidMessageException}")
    String invalidPassMessageException;

    @Override
    public void validate(CreateUserRequest request) {

        validateNameNotNull(request);
        validateEmailNotNull(request);
        validatePasswordNotNull(request);
        validatePhonesNotNull(request);
        validateNumberPhoneNotNull(request);
        validateCityCodePhoneNotNull(request);
        validateCountryCodePhoneNotNull(request);
        validateEmailFormat(request);
        validateEmialAlreadyExists(request);
        validatePasswordFormat(request);
    }

    private void validateNameNotNull(CreateUserRequest request) {
        if (request.getName() == null || request.getName().isEmpty()) {
            throw new RequestException("Nombre es requerido");
        }
    }

    private void validateEmailNotNull(CreateUserRequest request) {
        if (request.getEmail() == null || request.getEmail().isEmpty()) {
            throw new RequestException("Email es requerido");
        }
    }

    private void validatePasswordNotNull(CreateUserRequest request) {
        if (request.getPassword() == null || request.getPassword().isEmpty()) {
            throw new RequestException("Password es requerido");
        }
    }

    private void validatePhonesNotNull(CreateUserRequest request) {
        if (request.getPhones() == null) {
            throw new RequestException("Datos Telefonos son requeridos");
        }
    }

    private void validateNumberPhoneNotNull(CreateUserRequest request) {
        for (CreateUserPhoneRequestDTO createUserPhoneRequestDTO : request.getPhones()) {
            if (createUserPhoneRequestDTO.getNumber() == null || createUserPhoneRequestDTO.getNumber().isEmpty()) {
                throw new RequestException("Numerico de telefono es requerido");
            }
        }
    }

    private void validateCityCodePhoneNotNull(CreateUserRequest request) {
        for (CreateUserPhoneRequestDTO createUserPhoneRequestDTO : request.getPhones()) {
            if (createUserPhoneRequestDTO.getCitycode() == null || createUserPhoneRequestDTO.getCitycode().isEmpty()) {
                throw new RequestException("Codigo de ciudad de telefono es requerido");
            }
        }
    }

    private void validateCountryCodePhoneNotNull(CreateUserRequest request) {
        for (CreateUserPhoneRequestDTO createUserPhoneRequestDTO : request.getPhones()) {
            if (createUserPhoneRequestDTO.getContrycode() == null || createUserPhoneRequestDTO.getContrycode().isEmpty()) {
                throw new RequestException("Codigo de pais de telefono es requerido");
            }
        }
    }

    private void validateEmailFormat(CreateUserRequest request) {
        if (!EmailValidator.getInstance().isValid(request.getEmail())) {
            throw new RequestException("Email con formato incorrecto");
        }
    }

    private void validateEmialAlreadyExists(CreateUserRequest request) {
        Optional<User> user = userDAO.findByEmail(request.getEmail());
        if (user.isPresent()) {
            throw new BusinessException(HttpStatus.INTERNAL_SERVER_ERROR, "Email ya existe");
        }
    }

    private void validatePasswordFormat(CreateUserRequest request) {
        if (!ValidateUtils.isPasswordValid(passwordPatern, request.getPassword())) {
            throw new RequestException(invalidPassMessageException);
        }
    }
}