package com.ecocode.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ecocode.entities.User;
@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    List<User> findByfname(String name);
}
