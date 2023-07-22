package teatech.contactmanagement.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import teatech.contactmanagement.dto.RequestUserLogin;
import teatech.contactmanagement.dto.ResponseService;
import teatech.contactmanagement.dto.ResponseToken;
import teatech.contactmanagement.dto.WebResponse;
import teatech.contactmanagement.service.AuthService;
import teatech.contactmanagement.util.Constant;

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
    public ResponseService login(@RequestBody RequestUserLogin req) {
        log.info("Start controller login: {}", req.getUsername());
        ResponseToken responseToken = authService.login(req);
        String responseCode = Constant.RESPONSE.APPROVED.getCode();
        String responseDesc = Constant.RESPONSE.APPROVED.getDescription();
        Object data = responseToken;

        ResponseService response = new ResponseService();
        response.setResponseCode(responseCode);
        response.setResponseDesc(responseDesc);
        response.setData(data);
        log.info("End controller login: {}", req.getUsername());
//        return WebResponse.<ResponseToken>builder().data(responseToken).build();
        return response;
    }
}
