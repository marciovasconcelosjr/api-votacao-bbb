package me.dio.coding.votacao.bbb.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.annotation.processing.Generated;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("participants")
public class ParticipantModel {

    @Id
    private String id;
    private String name;

    public ParticipantModel(String name) {
        this.name = name;
    }
}
