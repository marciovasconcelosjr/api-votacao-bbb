package me.dio.coding.votacao.bbb.ms.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("votes")
public class VoteModel {

    @Id
    private String id;
    private ParticipantModel participant;
    private Date dateHour;
}
