package com.dev.managerEquip.Equipament.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.managerEquip.Equipament.dtos.request.EquipamentRequestCreate;
import com.dev.managerEquip.Equipament.dtos.response.EquipamentResponse;
import com.dev.managerEquip.Equipament.dtos.response.EquipamentListItemResponse;
import com.dev.managerEquip.Equipament.service.EquipamentService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/equipaments")
@RequiredArgsConstructor
public class EquipamentController {
    private final EquipamentService equipamentService;

    @PostMapping()
    public ResponseEntity<EquipamentResponse> createEquipament(@RequestBody EquipamentRequestCreate request) {
        EquipamentResponse response = equipamentService.addNewEquipament(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping()
    public ResponseEntity<List<EquipamentListItemResponse>> getAll(){
        List<EquipamentListItemResponse> response = equipamentService.getAllEquipaments();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EquipamentResponse> getById(@PathVariable UUID id) {
        EquipamentResponse response = equipamentService.getEquipamentById(id);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEquipament(@PathVariable UUID id) {
        equipamentService.deleteEquipament(id);
        return ResponseEntity.noContent().build();
    }
}
