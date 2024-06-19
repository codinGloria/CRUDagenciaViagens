package com.agenciaviagens.services;

import com.agenciaviagens.models.TravelDestination;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TravelDestinationServiceImpl implements TravelDestinationService {

    private final List<TravelDestination> destinations = new ArrayList<>();

    @Override
    public void addDestination(TravelDestination destino) {
        destino.setId((Integer) (destinations.size() + 1));
        destinations.add(destino);
    }

    @Override
    public List<TravelDestination> getAllDestinations() {
        return destinations;
    }

    @Override
    public TravelDestination getDestinationById(Integer id) {
        return destinations.stream()
                .filter(d -> d.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<TravelDestination> searchDestinations(String nome, String localizacao) {
        return destinations.stream()
                .filter(d -> (nome == null || d.getNome().equalsIgnoreCase(nome)))
                .filter(d -> (localizacao == null || d.getLocalizacao().equalsIgnoreCase(localizacao)))
                .collect(Collectors.toList());
    }

    @Override
    public void updateDestination(TravelDestination destino) {
        Integer id = destino.getId();
        destinations.stream()
                .filter(d -> d.getId().equals(id))
                .findFirst()
                .ifPresent(d -> {
                    d.setNome(destino.getNome());
                    d.setLocalizacao(destino.getLocalizacao());
                    d.setDescricao(destino.getDescricao());
                });
    }

    @Override
    public void rateDestination(Integer id, int rating) {
        TravelDestination destino = destinations.stream()
                .filter(d -> d.getId().equals(id))
                .findFirst()
                .orElse(null);

        if (destino != null) {
            double NotaMediaAtual = destino.getNotaMedia();
            int numeroDeAvaliacoes = destino.getNumeroDeAvaliacoes();

            double novaNotaMedia = (NotaMediaAtual * numeroDeAvaliacoes + rating) / (numeroDeAvaliacoes + 1);

            BigDecimal novaNotaMediaArredondada = BigDecimal.valueOf(novaNotaMedia)
                    .setScale(1, RoundingMode.HALF_UP);

            destino.setNotaMedia(novaNotaMediaArredondada.doubleValue());
            destino.setNumeroDeAvaliacoes(numeroDeAvaliacoes + 1);
        }
    }

    @Override
    public void deleteDestination(Integer id) {
        destinations.removeIf(d -> d.getId().equals(id));
    }
}
