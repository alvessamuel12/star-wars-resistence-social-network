package com.projectgroup.projectv1.model;

import com.projectgroup.projectv1.model.inventory.Inventory;
import lombok.*;

import java.util.UUID;

@Getter
@RequiredArgsConstructor
public class Rebel {
    @NonNull
    private UUID id;
    @NonNull
    private String name;
    @NonNull
    private Integer age;
    @NonNull
    private String gender;
    @Setter
    private Location location = new Location();
    private final Inventory inventory = new Inventory();
    private Integer reportCounts = 0;
    @Setter
    private boolean isTraitor = false;

    public void addReport() {
        this.reportCounts++;
    }
}
