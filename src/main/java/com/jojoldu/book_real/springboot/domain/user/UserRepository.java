package com.jojoldu.book_real.springboot.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    //이메일로 찾기
    Optional<User> findByEmail(String email);

}
