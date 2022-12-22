package me.dio.coding.votacao.bbb.api.service;

import lombok.RequiredArgsConstructor;
import me.dio.coding.votacao.bbb.api.model.ParameterModel;
import me.dio.coding.votacao.bbb.api.repository.ParameterRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ParameterService {

    private final ParameterRepository parameterRepository;

    public ParameterModel save(ParameterModel parameterModel) {
       return parameterRepository.save(parameterModel);
    }

    public Optional<ParameterModel> searchByKey(String key) {
        return parameterRepository.findById(key);
    }
}
