package me.dio.coding.votacao.bbb.api.controller;

import lombok.RequiredArgsConstructor;
import me.dio.coding.votacao.bbb.api.model.ParameterModel;
import me.dio.coding.votacao.bbb.api.service.ParameterService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.Optional;

@RestController
@RequestMapping("/api/params")
@RequiredArgsConstructor
public class ParameterController {

    private final ParameterService parameterService;

    @PostMapping("/save")
    public ResponseEntity<ParameterModel> save(@RequestBody ParameterModel parameterModel) {
        return ResponseEntity.ok(parameterService.save(parameterModel));
    }

    @GetMapping("/search")
    public ResponseEntity<ParameterModel> search(@RequestParam String key) throws Exception {
        Optional<ParameterModel> parameterModel = parameterService.searchByKey(key);
        if (parameterModel.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(parameterModel.get());
    }
}
