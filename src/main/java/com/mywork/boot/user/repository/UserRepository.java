package com.mywork.boot.user.repository;

import com.mywork.boot.user.dto.SiteUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<SiteUser, Long> {

}
