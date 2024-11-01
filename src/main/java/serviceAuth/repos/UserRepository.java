package serviceAuth.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import serviceAuth.entities.AppUser;

public interface UserRepository extends JpaRepository<AppUser, Long> {
    public AppUser findByUsername(String email);
}
