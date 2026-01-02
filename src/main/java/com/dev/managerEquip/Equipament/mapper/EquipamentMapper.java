package com.dev.managerEquip.Equipament.mapper;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

import com.dev.managerEquip.Equipament.dtos.request.EquipamentRequestCreate;
import com.dev.managerEquip.Equipament.dtos.response.EquipamentResponse;
import com.dev.managerEquip.Equipament.dtos.response.EquipamentListItemResponse;
import com.dev.managerEquip.Equipament.enums.EquipamentStatus;
import com.dev.managerEquip.Equipament.model.Equipament;

@Component
public class EquipamentMapper {

    public Equipament toEntity(EquipamentRequestCreate request){
        if (request == null) {
            return null;
        }

        return new Equipament(
            null,
            request.name(),
            request.model(),
            request.serialNumber(),
            EquipamentStatus.ACTIVE
        );
    }

    public EquipamentResponse toResponse(Equipament equipament){
        if (equipament == null) {
            return null;
        }

        String id = equipament.getId() == null ? null : equipament.getId().toString();
        String status = equipament.getStatus() == null ? null : equipament.getStatus().name();

        return new EquipamentResponse(
           id,
           equipament.getName(),
           equipament.getModel(),
           equipament.getSerialNumber(),
           status
        );
    }

    public EquipamentListItemResponse toListItem(Equipament equipament) {
        if (equipament == null) {
            return null;
        }

        String id = equipament.getId() == null ? null : equipament.getId().toString();
        String status = equipament.getStatus() == null ? null : equipament.getStatus().name();

        return new EquipamentListItemResponse(
            id,
            equipament.getName(),
            equipament.getModel(),
            equipament.getSerialNumber(),
            status
        );
    }

    public List<EquipamentListItemResponse> toListResponse(List<Equipament> equipaments) {
        if (equipaments == null) {
            return null;
        }
        return equipaments.stream()
            .map(this::toListItem)
            .collect(Collectors.toList());
    }
}
