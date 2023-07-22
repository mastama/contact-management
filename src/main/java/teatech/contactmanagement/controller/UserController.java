package teatech.contactmanagement.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import teatech.contactmanagement.dto.RequestUserRegister;
import teatech.contactmanagement.dto.WebResponse;
import teatech.contactmanagement.service.UserService;
import teatech.contactmanagement.util.Constant;

@Slf4j
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping(
            path = "/api/users",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<String> register(@RequestBody RequestUserRegister req) {
        log.info("Start controller register: {}", req.getUsername());
        userService.register(req);
        log.info("End controller register: {}", req.getUsername());
        String responseCode = Constant.RESPONSE.APPROVED.getCode();
        String responseDesc = Constant.RESPONSE.APPROVED.getDescription();
//        return WebResponse.<String>builder().data("register success").build();
        return new WebResponse<>(responseCode, responseDesc, "Registrasi berhasil! Akun Anda telah berhasil dibuat.");
    }
}
