package serviceAuth.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import serviceAuth.entities.AppRole;

public interface RoleRepository extends JpaRepository<AppRole, Integer> {
}
