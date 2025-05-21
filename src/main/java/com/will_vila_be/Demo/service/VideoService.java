package com.will_vila_be.Demo.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.will_vila_be.Demo.model.Video;
import com.will_vila_be.Demo.repository.VideoRepository;

@Service
public class VideoService {
    
    private final VideoRepository videoRepository;

    public VideoService(VideoRepository videoRepository){
        this.videoRepository = videoRepository;
    }

    public ResponseEntity<Object> createVideo(Video video){
        videoRepository.save(video);
        return new ResponseEntity<>(video, HttpStatus.CREATED);
    }
}
