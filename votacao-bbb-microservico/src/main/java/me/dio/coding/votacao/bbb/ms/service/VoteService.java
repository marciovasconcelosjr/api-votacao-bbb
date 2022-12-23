package me.dio.coding.votacao.bbb.ms.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.dio.coding.votacao.bbb.ms.model.ParticipantModel;
import me.dio.coding.votacao.bbb.ms.model.VoteModel;
import me.dio.coding.votacao.bbb.ms.repository.VoteRepository;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@Slf4j
@RequiredArgsConstructor
public class VoteService {

    private final VoteRepository repository;

    @KafkaListener(topics = "votacao", groupId = "MicroServicoVotacao")
    private void execute(ConsumerRecord<String, String> register) {
        String participantStr = register.value();
        log.info("Voto recebido = {}", participantStr);

        ObjectMapper mapper = new ObjectMapper();
        ParticipantModel participant = null;

        try {
            participant = mapper.readValue(participantStr, ParticipantModel.class);
        } catch (JsonProcessingException e) {
            log.error("Falha ao converter voto [{}]", participantStr, e);
            return;
        }

        VoteModel vote = new VoteModel(null, participant, new Date());
        VoteModel entity = repository.save(vote);

        log.info("Voto registrado, [id={}, dataHora={}", entity.getId(), entity.getDateHour());
    }
}
