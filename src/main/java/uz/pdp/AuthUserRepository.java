package uz.pdp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "users")
public interface AuthUserRepository extends JpaRepository<AuthUserEntity, Long> {
}
