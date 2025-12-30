package com.dev.managerEquip.Equipament.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dev.managerEquip.Equipament.model.Equipament;


@Repository
public interface EquipamentRepository extends JpaRepository<Equipament, UUID> {
    Optional<Equipament> findBySerialNumber(String serialNumber);
}
