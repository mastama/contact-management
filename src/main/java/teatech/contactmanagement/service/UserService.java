package teatech.contactmanagement.service;

import jakarta.transaction.Transactional;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import teatech.contactmanagement.dto.RequestUserRegister;
import teatech.contactmanagement.entity.User;
import teatech.contactmanagement.repository.UserRepository;
import teatech.contactmanagement.security.BCrypt;

import java.util.Set;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private Validator validator;

    @Transactional
    public void register(RequestUserRegister req) {
        log.info("Start service register: {}", req.getUsername());
        Set<ConstraintViolation<RequestUserRegister>> constraintViolations = validator.validate(req);
        if (!constraintViolations.isEmpty()) {
            throw new ConstraintViolationException(constraintViolations);
        }

        if (userRepository.existsById(req.getUsername())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Username already registered");
        }

        // buat object nya
        User user = new User();
        user.setUsername(req.getUsername());
        user.setPassword(BCrypt.hashpw(req.getPassword(), BCrypt.gensalt()));
        user.setName(req.getName());

        userRepository.save(user);
        log.info("End Service register: {}", req.getUsername());
    }
}
