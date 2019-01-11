package com.pillar.cardholder;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CardholderRepository extends JpaRepository<Cardholder, Integer> {
    Optional<Cardholder> findOneBySsn(String name);
}
