package com.memoire.demo.outils;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppRepositery extends JpaRepository<User, Integer> {

}
