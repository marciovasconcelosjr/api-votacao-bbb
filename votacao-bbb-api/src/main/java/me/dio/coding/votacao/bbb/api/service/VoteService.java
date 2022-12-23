package me.dio.coding.votacao.bbb.api.service;

import lombok.AllArgsConstructor;
import me.dio.coding.votacao.bbb.api.model.ParticipantModel;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class VoteService {

    private final KafkaTemplate<Object, Object> template;
    private static final String TOPICO_VOTACAO = "votacao";

    public void addEvent(ParticipantModel participant) {
        template.send(TOPICO_VOTACAO, participant);
    }
}
