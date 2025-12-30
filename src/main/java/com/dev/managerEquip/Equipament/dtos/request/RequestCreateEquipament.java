package com.dev.managerEquip.Equipament.dtos.request;

public record RequestCreateEquipament(
    String name,
    String model,
    String serialNumber,
    String status) 
    {
}
