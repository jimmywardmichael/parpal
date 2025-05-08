package com.codeup.parpal.repositories;

import com.codeup.parpal.models.Pals;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PalsRepository extends JpaRepository<Pals, Long> {
}
