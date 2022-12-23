package me.dio.coding.votacao.bbb.api.controller;

import lombok.RequiredArgsConstructor;
import me.dio.coding.votacao.bbb.api.model.ParticipantModel;
import me.dio.coding.votacao.bbb.api.service.ParticipantService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/participants")
@RequiredArgsConstructor
public class ParticipantController {

    private final ParticipantService participantService;

    @PostMapping("/save")
    public ResponseEntity<ParticipantModel> save(@RequestBody ParticipantModel participantModel) {
        return ResponseEntity.ok(participantService.save(participantModel));
    }

    @GetMapping("/search")
    public ResponseEntity<ParticipantModel> search(@RequestParam String key) throws Exception {
        Optional<ParticipantModel> participantModel = participantService.searchById(key);
        if (participantModel.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(participantModel.get());
    }

    @GetMapping
    public ResponseEntity<List<ParticipantModel>> findAll() {
        return ResponseEntity.ok(participantService.findAll());
    }
}
