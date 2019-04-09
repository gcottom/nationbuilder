package nationbuilder.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import nationbuilder.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{
}
