package com.bosonit.Ej15Security.role.infrastructure.repository;


import com.bosonit.Ej15Security.role.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

    Role findByName(String name);
}
