package me.dio.coding.votacao.bbb.api.controller;

import lombok.RequiredArgsConstructor;
import me.dio.coding.votacao.bbb.api.dto.Mapper;
import me.dio.coding.votacao.bbb.api.dto.ParticipantDto;
import me.dio.coding.votacao.bbb.api.model.ParticipantModel;
import me.dio.coding.votacao.bbb.api.service.ParticipantService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/participants")
@RequiredArgsConstructor
@CrossOrigin
public class ParticipantController {

    private final ParticipantService participantService;
    private final Mapper mapper;

    @PostMapping("/save")
    public ResponseEntity<ParticipantModel> save(@RequestBody ParticipantModel participantModel) {
        return ResponseEntity.ok(participantService.save(participantModel));
    }

    @GetMapping("/search/id")
    public ResponseEntity<ParticipantDto> search(@RequestParam String id) throws Exception {
        List<ParticipantDto> dtoList = participantService.searchById(id).stream().map(mapper::toDto).collect(Collectors.toList());
        if (dtoList.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(dtoList.get(0));
    }

    @GetMapping
    public ResponseEntity<List<ParticipantDto>> findAll() {
        List<ParticipantDto> dtoList = participantService.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
        return ResponseEntity.ok(dtoList);
    }

    @GetMapping("/search/name")
    public ResponseEntity<ParticipantModel> findByName(@RequestParam String name) {
        ParticipantModel participantModel = participantService.searchByName(name).stream().findFirst().get();
        return ResponseEntity.ok(participantModel);
    }
}
