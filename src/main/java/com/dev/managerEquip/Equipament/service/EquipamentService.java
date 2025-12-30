package com.dev.managerEquip.Equipament.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.dev.managerEquip.Equipament.dtos.request.RequestCreateEquipament;
import com.dev.managerEquip.Equipament.dtos.response.ResponseCreateEquipament;
import com.dev.managerEquip.Equipament.exceptions.ResourceAlreadyExistsException;
import com.dev.managerEquip.Equipament.exceptions.ResourceNotFoundException;
import com.dev.managerEquip.Equipament.mapper.EquipamentMapper;
import com.dev.managerEquip.Equipament.model.Equipament;
import com.dev.managerEquip.Equipament.repository.EquipamentRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class EquipamentService {
    private final EquipamentRepository equipamentRepository;
    private final EquipamentMapper mapper;
 
    public ResponseCreateEquipament addNewEquipament(RequestCreateEquipament request){
        validateRequest(request);

        log.info("Adicionando novo equipamento: {}", request.serialNumber());
        if (equipamentRepository.findBySerialNumber(request.serialNumber()).isPresent()) {
            log.error("Equipamento com o número de série {} já existe.", request.serialNumber());
            throw new ResourceAlreadyExistsException("Equipamento já existe.");
        }
        Equipament newEquipament = mapper.toEntity(request);
        log.info("Nome: {}, Modelo: {}, Número de série: {}, Status: {}", newEquipament.getName(), newEquipament.getModel(), newEquipament.getSerialNumber(), newEquipament.getStatus());
        equipamentRepository.save(newEquipament);
        log.info("Equipamento salvo com sucesso: {}", newEquipament.getId());
        return mapper.toResponse(newEquipament);
    }

    public void deleteEquipament(UUID id) {
        log.info("Desativando equipamento com ID: {}", id);
        Equipament entity = equipamentRepository.findById(id).orElseThrow(() -> {
            log.error("Equipamento com ID {} não encontrado.", id);
            return new ResourceNotFoundException("Equipamento não encontrado.");
        });
        // entity.deactivate();
        equipamentRepository.save(entity);
        log.info("Equipamento desativado com sucesso: {}", id);
    }

    private void validateRequest(RequestCreateEquipament request) {
        if (request == null) {
            log.error("RequestCreateEquipament é nulo");
            throw new IllegalArgumentException("Request não pode ser nulo");
        }

        if (request.name() == null || request.name().isBlank()
                || request.model() == null || request.model().isBlank()
                || request.serialNumber() == null || request.serialNumber().isBlank()
                || request.status() == null || request.status().isBlank()) {
            log.error("RequestCreateEquipament com campos obrigatórios ausentes ou vazios: {}", request);
            throw new IllegalArgumentException("Campos obrigatórios ausentes ou vazios");
        }
    }
    }
