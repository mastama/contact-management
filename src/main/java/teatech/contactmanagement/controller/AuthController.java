package teatech.contactmanagement.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import teatech.contactmanagement.dto.RequestUserLogin;
import teatech.contactmanagement.dto.ResponseToken;
import teatech.contactmanagement.dto.WebResponse;
import teatech.contactmanagement.service.AuthService;

@RestController
@Slf4j
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping(
            path = "/api/auth/login",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<ResponseToken> login(@RequestBody RequestUserLogin req) {
        log.info("Start controller login: {}", req.getUsername());
        ResponseToken responseToken = authService.login(req);
        log.info("End controller login: {}", req.getUsername());
        return WebResponse.<ResponseToken>builder().data(responseToken).build();
    }
}
