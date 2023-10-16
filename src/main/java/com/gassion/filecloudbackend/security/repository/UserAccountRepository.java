package com.gassion.filecloudbackend.security.repository;

import com.gassion.filecloudbackend.security.model.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAccountRepository extends JpaRepository<UserAccount, Long> {

    public boolean existsByUsername(String username);

}
