package me.dio.coding.votacao.bbb.ms.repository;

import me.dio.coding.votacao.bbb.ms.model.VoteModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoteRepository extends MongoRepository<VoteModel, String> {
}
