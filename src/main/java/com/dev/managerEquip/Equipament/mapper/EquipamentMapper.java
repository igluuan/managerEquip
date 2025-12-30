package com.dev.managerEquip.Equipament.mapper;

import org.springframework.stereotype.Component;

import com.dev.managerEquip.Equipament.dtos.request.RequestCreateEquipament;
import com.dev.managerEquip.Equipament.dtos.response.ResponseCreateEquipament;
import com.dev.managerEquip.Equipament.model.Equipament;

@Component
public class EquipamentMapper {

    public Equipament toEntity(RequestCreateEquipament request){
        if (request == null) {
            return null;
        }

        return new Equipament(
            null,
            request.name(),
            request.model(),
            request.serialNumber(),
            request.status()
        );
    }

    public ResponseCreateEquipament toResponse(Equipament equipament){
        if (equipament == null) {
            return null;
        }

        String id = equipament.getId() == null ? null : equipament.getId().toString();
        String status = equipament.getStatus() == null ? null : equipament.getStatus();

        return new ResponseCreateEquipament(
           id,
           equipament.getName(),
           equipament.getModel(),
           equipament.getSerialNumber(),
           status
        );
    }
}
