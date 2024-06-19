package com.agenciaviagens.services;

import com.agenciaviagens.models.TravelDestination;

import java.util.List;

public interface TravelDestinationService {

    void addDestination(TravelDestination destino);

    List<TravelDestination> getAllDestinations();

    TravelDestination getDestinationById(Integer id);

    List<TravelDestination> searchDestinations(String nome, String localizacao);

    void updateDestination(TravelDestination destino);

    void rateDestination(Integer id, int rating);

    void deleteDestination(Integer id);
}
