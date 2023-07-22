package teatech.contactmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import teatech.contactmanagement.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
}
