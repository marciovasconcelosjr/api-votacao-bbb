package me.dio.coding.votacao.bbb.api.repository;

import me.dio.coding.votacao.bbb.api.model.ParticipantModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParticipantRepository extends MongoRepository<ParticipantModel, String> {

    List<ParticipantModel> findByName(String name);
}
