package com.dev.managerEquip.Equipament.dtos.response;

public record EquipamentListItemResponse(
    String id,
    String name,
    String model,
    String serialNumber,
    String status) {
}
