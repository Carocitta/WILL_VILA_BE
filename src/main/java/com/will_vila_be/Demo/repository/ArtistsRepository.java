package com.will_vila_be.Demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.will_vila_be.Demo.model.Artists;

public interface ArtistsRepository extends JpaRepository<Artists, Integer> {
}
