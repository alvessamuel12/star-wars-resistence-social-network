package com.projectgroup.projectv1.dto;

import com.projectgroup.projectv1.model.Location;
import com.projectgroup.projectv1.model.Rebel;
import com.projectgroup.projectv1.model.inventory.Inventory;
import lombok.Getter;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Getter
public class RebelResponse {
    private UUID id;
    private String name;
    private Integer age;
    private String gender;
    private Location location;
    private Inventory inventory;

    public RebelResponse(Rebel rebel) {
        this.id = rebel.getId();
        this.name = rebel.getName();
        this.age = rebel.getAge();
        this.gender = rebel.getGender();
        this.location = rebel.getLocation();
        this.inventory = rebel.getInventory();
    }

    public static List<RebelResponse> toResponse(List<Rebel> rebels){
        return  rebels.stream().map(RebelResponse::new).collect(Collectors.toList());
    }
}
