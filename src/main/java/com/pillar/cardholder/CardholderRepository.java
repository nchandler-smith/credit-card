package com.pillar.cardholder;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CardholderRepository extends JpaRepository<Cardholder, Integer> {
}
