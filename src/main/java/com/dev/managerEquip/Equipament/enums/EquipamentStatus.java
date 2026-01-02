package com.dev.managerEquip.Equipament.enums;

public enum EquipamentStatus {
    ACTIVE(1L),
    INACTIVE(2L);

    private final Long statusId;
    EquipamentStatus(Long statusId) {
        this.statusId = statusId;
    }
    public Long getStatusId() {
        return statusId;
    }
}

