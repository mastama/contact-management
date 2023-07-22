package teatech.contactmanagement.service;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import teatech.contactmanagement.dto.RequestUserLogin;
import teatech.contactmanagement.dto.ResponseToken;
import teatech.contactmanagement.entity.User;
import teatech.contactmanagement.repository.UserRepository;
import teatech.contactmanagement.security.BCrypt;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.UUID;

@Service
@Slf4j
public class AuthService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ValidationService validationService;

    /**
     * @Transactional
     * Digunakan karena service ini memanipulasi ke database
     */
    @Transactional
    public ResponseToken login(RequestUserLogin req) {
        log.info("Start service login: {}", req.getUsername());
        // validasi terlebih dulu
        validationService.validate(req);

        // cek apakah datanya sudah ada di db
        User user = userRepository.findById(req.getUsername())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Username or password wrong"));
        if (BCrypt.checkpw(req.getPassword(), user.getPassword())) {
            // success
            user.setToken(UUID.randomUUID().toString());
            user.setTokenExpiredAt(next2Hours());
            userRepository.save(user);

            log.info("End service login: {}", req.getUsername());
            return ResponseToken.builder()
                    .token(user.getToken())
                    .expiredAt(user.getTokenExpiredAt())
                    .build();
        } else {
            // failed
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Username or password wrong");
        }
    }


    private Long next30Days() {
        return System.currentTimeMillis() + (1000 * 16 * 24 * 30);
    }

    private Long next2Hours() {
        return System.currentTimeMillis() + (2 * 60 * 60 * 1000);
    }

    // tambahkan static supaya bisa di running
    public void main(String[] args) {
        long expiredDate30Days = next30Days();
        long expiredDate2Hours = next2Hours();

        // Konversi ke objek Date untuk keperluan penampilan
        Date expiredAtDate30 = new Date(expiredDate30Days);
        Date expiredAtDate2 = new Date(expiredDate2Hours);

        // Konversi ke objek LocalDateTime untuk keperluan penampilan
        LocalDateTime expiredAtLocalDateTime = LocalDateTime.ofInstant(
                java.time.Instant.ofEpochMilli(expiredDate2Hours),
                ZoneId.systemDefault()
        );

        System.out.println("Waktu saat ini: {}" + new Date());
        System.out.println("Waktu kadaluarsa token 30 hari: {}" + expiredAtDate30);
        System.out.println("Waktu kadaluarsa token 2 hours: {}" + expiredAtDate2);
        System.out.println("=====================================================");
        System.out.println("Waktu Kedaluwarsa LOKAL Token (2 Jam): " + expiredAtLocalDateTime);

    }
}
