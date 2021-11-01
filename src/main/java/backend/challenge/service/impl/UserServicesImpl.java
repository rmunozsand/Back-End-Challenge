package backend.challenge.service.impl;

import backend.challenge.dao.PhoneDAO;
import backend.challenge.dao.UserDAO;
import backend.challenge.entities.Phone;
import backend.challenge.entities.User;
import backend.challenge.entities.dto.CreateUserPhoneRequestDTO;
import backend.challenge.entities.request.CreateUserRequest;
import backend.challenge.entities.response.CreateUserResponse;
import backend.challenge.exception.BusinessException;
import backend.challenge.exception.RequestException;
import backend.challenge.exception.UnexpectedException;
import backend.challenge.service.RequestValidator;
import backend.challenge.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.UUID;

@Service
public class UserServicesImpl implements UserService {

    @Autowired
    private RequestValidator requestValidator;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private PhoneDAO phoneDAO;

    @Autowired
    private HttpHeaders headers;

    @Override
    public CreateUserResponse createUser(CreateUserRequest request) {
        try {
            requestValidator.validate(request);

            UUID newUserUuid = UUID.randomUUID();

            User newUser = new User();
            newUser.setId(newUserUuid);
            newUser.setName(request.getName());
            newUser.setEmail(request.getEmail());
            newUser.setPassword(passwordEncoder.encode(request.getPassword()));
            userDAO.save(newUser);

            for (CreateUserPhoneRequestDTO createUserPhoneRequestDTO : request.getPhones()) {
                Phone newPhone = new Phone();
                newPhone.setPhoneId(UUID.randomUUID());
                newPhone.setUserId(newUserUuid);
                newPhone.setNumber(createUserPhoneRequestDTO.getNumber());
                newPhone.setCitycode(createUserPhoneRequestDTO.getCitycode());
                newPhone.setContrycode(createUserPhoneRequestDTO.getContrycode());
                phoneDAO.save(newPhone);
            }

            CreateUserResponse response = new CreateUserResponse();
            response.setId(newUserUuid);
            response.setCreated(newUser.getCreated());
            response.setModified(newUser.getModified());
            response.setLast_login(newUser.getLast_login());
            response.setToken(headers.get("Authorization").get(0));
            response.setActive(newUser.getState().equalsIgnoreCase("ACTIVE") ? true : false);

            return response;
        } catch (RequestException | BusinessException e) {
            throw e;
        } catch (RuntimeException e) {
            e.printStackTrace();
            throw new UnexpectedException("Ha ocurrido un error inesperado");
        }
    }
}