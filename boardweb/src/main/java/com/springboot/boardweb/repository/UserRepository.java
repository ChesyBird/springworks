package com.springboot.boardweb.repository;

import com.springboot.boardweb.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    // 회원가입 시 중복확인
    boolean existsByUsername(String username);

    // 아이디로 회원 조회(Optional : 아이디가 없을 때 null처리)
    Optional<User> findByUsername(String username);
}
