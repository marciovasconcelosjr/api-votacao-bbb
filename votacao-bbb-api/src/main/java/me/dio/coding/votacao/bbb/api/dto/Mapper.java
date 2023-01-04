package me.dio.coding.votacao.bbb.api.dto;

import me.dio.coding.votacao.bbb.api.model.ParticipantModel;
import org.springframework.stereotype.Component;

@Component
public class Mapper {

    public ParticipantDto toDto(ParticipantModel participantModel) {
        String name = participantModel.getName();
        return new ParticipantDto(name);
    }

    public ParticipantModel toModel(ParticipantDto participantDto) {
        return new ParticipantModel(participantDto.getName());
    }
}
