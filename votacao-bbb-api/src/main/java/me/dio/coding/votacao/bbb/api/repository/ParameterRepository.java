package me.dio.coding.votacao.bbb.api.repository;

import me.dio.coding.votacao.bbb.api.model.ParameterModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParameterRepository extends MongoRepository<ParameterModel, String> {
}
