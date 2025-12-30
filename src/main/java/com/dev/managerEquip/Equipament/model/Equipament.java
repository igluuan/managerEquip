package com.dev.managerEquip.Equipament.model;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    private String model;
    private String serialNumber;
    // @Enumerated(EnumType.STRING)
    private String status;

    // public void deactivate() {
    //     this.status = "desativado";
    // }
}
