package com.agenciaviagens.controllers;

import com.agenciaviagens.models.TravelDestination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.agenciaviagens.services.TravelDestinationService;
import java.util.List;

@RestController
@RequestMapping("/destinos")
public class TravelDestinationController {

    private final TravelDestinationService destinationService;

    @Autowired
    public TravelDestinationController(TravelDestinationService destinationService) {
        this.destinationService = destinationService;
    }

    @PostMapping
    public ResponseEntity<Void> addDestination(@RequestBody TravelDestination destino) {
        destinationService.addDestination(destino);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<List<TravelDestination>> getAllDestinations() {
        List<TravelDestination> destinations = destinationService.getAllDestinations();
        return ResponseEntity.ok(destinations);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TravelDestination> getDestinationById(@PathVariable Integer id) {
        TravelDestination destination = destinationService.getDestinationById(id);
        if (destination != null) {
            return ResponseEntity.ok(destination);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/search")
    public ResponseEntity<List<TravelDestination>> searchDestinations(
            @RequestParam(required = false) String nome,
            @RequestParam(required = false) String localizacao) {
        List<TravelDestination> destinos = destinationService.searchDestinations(nome, localizacao);
        return ResponseEntity.ok(destinos);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateDestination(@PathVariable Integer id, @RequestBody TravelDestination destino) {
        destino.setId(id);
        destinationService.updateDestination(destino);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/{id}/rate")
    public ResponseEntity<Void> rateDestination(
            @PathVariable Integer id,
            @RequestParam int rating) {
        destinationService.rateDestination(id, rating);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDestination(@PathVariable Integer id) {
        destinationService.deleteDestination(id);
        return ResponseEntity.ok().build();
    }

}
