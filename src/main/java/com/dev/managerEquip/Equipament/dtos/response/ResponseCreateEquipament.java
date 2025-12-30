package com.dev.managerEquip.Equipament.dtos.response;

public record ResponseCreateEquipament(
    String id,
    String name,
    String model,
    String serialNumber,
    String status) 
    {
}
