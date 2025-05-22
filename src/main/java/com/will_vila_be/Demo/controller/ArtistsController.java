package com.will_vila_be.Demo.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.will_vila_be.Demo.model.Artists;
import com.will_vila_be.Demo.service.ArtistsService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("api/v1/artists")
public class ArtistsController {

    private final ArtistsService artistsService;

    public ArtistsController(ArtistsService artistsService) {
        this.artistsService = artistsService;
    }

    @PostMapping
    public ResponseEntity<Object> createArtists(@Valid @RequestBody Artists artists) {
        return artistsService.createArtists(artists);
    }

    @GetMapping
    public List<Artists> getAllArtists() {
        return artistsService.getAllArtists();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getArtistsById(@PathVariable int id) {
        return artistsService.getArtistsById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateArtists(@PathVariable int id, @Valid @RequestBody Artists artists) {
        return artistsService.updateArtists(id, artists);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteArtists(@PathVariable int id) {
        return artistsService.deleteArtists(id);
    }
}
