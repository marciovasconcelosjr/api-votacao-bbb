package me.dio.coding.votacao.bbb.api.controller;

import lombok.AllArgsConstructor;
import me.dio.coding.votacao.bbb.api.model.ParticipantModel;
import me.dio.coding.votacao.bbb.api.repository.ParticipantRepository;
import me.dio.coding.votacao.bbb.api.service.VoteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Part;
import java.util.Optional;

@RestController
@RequestMapping("/api/vote")
@AllArgsConstructor
@CrossOrigin
public class VoteController {

    private final VoteService voteService;
    private final ParticipantRepository participantRepository;

    @PostMapping
    public ResponseEntity<ParticipantModel> voting(@RequestBody ParticipantModel participantModel) {

        Optional<ParticipantModel> responseOpt = participantRepository.findById(participantModel.getId());
        if (responseOpt.isEmpty()) {
            throw new RuntimeException("Código [" + participantModel.getId() + "] invalido para votação.");
        }

        ParticipantModel response = responseOpt.get();

        voteService.addEvent(response);
        return ResponseEntity.ok(response);
    }
}
