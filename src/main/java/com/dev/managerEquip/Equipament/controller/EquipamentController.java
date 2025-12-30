package com.dev.managerEquip.Equipament.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.managerEquip.Equipament.dtos.request.RequestCreateEquipament;
import com.dev.managerEquip.Equipament.dtos.response.ResponseCreateEquipament;
import com.dev.managerEquip.Equipament.service.EquipamentService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/equipaments")
@RequiredArgsConstructor
public class EquipamentController {
    private final EquipamentService equipamentService;

    @PostMapping()
    public ResponseEntity<ResponseCreateEquipament> createEquipament(@RequestBody RequestCreateEquipament request) {
        ResponseCreateEquipament response = equipamentService.addNewEquipament(request);
        return ResponseEntity.ok(response);
    }
}
