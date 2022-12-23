package me.dio.coding.votacao.bbb.api.service;

import lombok.RequiredArgsConstructor;
import me.dio.coding.votacao.bbb.api.model.ParticipantModel;
import me.dio.coding.votacao.bbb.api.repository.ParticipantRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ParticipantService {

    private final ParticipantRepository participantRepository;

    public ParticipantModel save(ParticipantModel participantModel) {
        return participantRepository.save(participantModel);
    }

    public Optional<ParticipantModel> searchById(String key) {
        return participantRepository.findById(key);
    }

    public List<ParticipantModel> findAll() {
        return participantRepository.findAll();
    }
}
