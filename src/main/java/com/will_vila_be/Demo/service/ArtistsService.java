package com.will_vila_be.Demo.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.will_vila_be.Demo.model.Artists;
import com.will_vila_be.Demo.repository.ArtistsRepository;

@Service
public class ArtistsService {

    private final ArtistsRepository artistsRepository;

    public ArtistsService(ArtistsRepository artistsRepository) {
        this.artistsRepository = artistsRepository;
    }

    public ResponseEntity<Object> createArtists(Artists artists) {
        artistsRepository.save(artists);
        return new ResponseEntity<>(artists, HttpStatus.CREATED);
    }

    public List<Artists> getAllArtists() {
        return artistsRepository.findAll();
    }

    public ResponseEntity<Object> getArtistsById(int id) {
        Optional<Artists> artist = artistsRepository.findById(id);
        if (artist.isPresent()) {
            return new ResponseEntity<>(artist.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(Map.of("error", "Artists not found"), HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Object> updateArtists(int id, Artists updatedArtists) {
        Optional<Artists> artistOpt = artistsRepository.findById(id);
        if (artistOpt.isPresent()) {
            Artists artist = artistOpt.get();
            artist.setName(updatedArtists.getName());
            artist.setBand(updatedArtists.getBand());
            artistsRepository.save(artist);
            return new ResponseEntity<>(artist, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(Map.of("error", "Artists not found"), HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Object> deleteArtists(int id) {
        Optional<Artists> artist = artistsRepository.findById(id);
        if (artist.isPresent()) {
            artistsRepository.deleteById(id);
            return new ResponseEntity<>(Map.of("message", "Artists deleted successfully"), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(Map.of("error", "Artists not found"), HttpStatus.NOT_FOUND);
        }
    }
}
