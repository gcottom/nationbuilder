package com.gagecottom.nationbuilder.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gagecottom.nationbuilder.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{
}
