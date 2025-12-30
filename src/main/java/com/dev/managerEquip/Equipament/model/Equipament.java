package com.dev.managerEquip.Equipament.model;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TB_EQUIPAMENT")
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Equipament {
    private UUID id;
    private String name;
    private String model;
    private String serialNumber;
    private String status;
}
