package com.bankproject.bank.repository;

import com.bankproject.bank.entity.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProfileRepository extends JpaRepository<Profile,Long> {

    Optional<Profile> findByUsername(String username);

    void  deleteByUsername(String username);
}
