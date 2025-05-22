package com.will_vila_be.Demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.will_vila_be.Demo.model.Video;
import com.will_vila_be.Demo.repository.VideoRepository;

@Service
public class VideoService {

    private final VideoRepository videoRepository;

    public VideoService(VideoRepository videoRepository) {
        this.videoRepository = videoRepository;
    }

    public ResponseEntity<Object> createVideo(Video video) {
        videoRepository.save(video);
        return new ResponseEntity<>(video, HttpStatus.CREATED);
    }

    public List<Video> getAllVideos() {
        return videoRepository.findAll();
    }

    public ResponseEntity<Object> getVideoById(int id) {
        Optional<Video> video = videoRepository.findById(id);
        if (video.isPresent()) {
            return new ResponseEntity<>(video.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Video not found", HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Object> updateVideo(int id, Video updatedVideo) {
        Optional<Video> existingVideo = videoRepository.findById(id);
        if (existingVideo.isPresent()) {
            Video video = existingVideo.get();
            video.setTitle(updatedVideo.getTitle());
            video.setArtist(updatedVideo.getArtist());
            video.setDate(updatedVideo.getDate());
            video.setUrl(updatedVideo.getUrl());
            videoRepository.save(video);
            return new ResponseEntity<>(video, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Video not found", HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Object> deleteVideo(int id) {
        Optional<Video> video = videoRepository.findById(id);
        if (video.isPresent()) {
            videoRepository.deleteById(id);
            return new ResponseEntity<>("Video deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Video not found", HttpStatus.NOT_FOUND);
        }
    }
}
