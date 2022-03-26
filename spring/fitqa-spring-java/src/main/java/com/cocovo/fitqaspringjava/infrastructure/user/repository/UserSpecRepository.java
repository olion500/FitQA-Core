package com.cocovo.fitqaspringjava.infrastructure.user.repository;

import com.cocovo.fitqaspringjava.domain.user.entity.UserSpec;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserSpecRepository extends JpaRepository<UserSpec, Long> {
}
