package com.will_vila_be.Demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.will_vila_be.Demo.model.Video;

public interface VideoRepository extends JpaRepository<Video, Integer> {}
