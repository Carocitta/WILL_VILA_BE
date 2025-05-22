package com.will_vila_be.Demo.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.will_vila_be.Demo.model.Video;
import com.will_vila_be.Demo.service.VideoService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("api/v1/video")
public class VideoController {

    private final VideoService videoService;

    public VideoController(VideoService videoService) {
        this.videoService = videoService;
    }

    @PostMapping
    public ResponseEntity<Object> createVideo(@Valid @RequestBody Video video) {
        return videoService.createVideo(video);
    }

    @GetMapping
    public List<Video> getAllVideos() {
        return videoService.getAllVideos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getVideoById(@PathVariable int id) {
        return videoService.getVideoById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateVideo(@PathVariable int id, @Valid @RequestBody Video video) {
        return videoService.updateVideo(id, video);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteVideo(@PathVariable int id) {
        return videoService.deleteVideo(id);
    }
}
