package com.projectgroup.projectv1.model;

import com.projectgroup.projectv1.model.inventory.Inventory;
import lombok.*;

import java.util.UUID;

@Setter
@Getter
@RequiredArgsConstructor
@AllArgsConstructor
public class Rebel {
    @NonNull
    private UUID id;

    @NonNull
    private String name;
    
    @NonNull
    private Integer age;
    
    @NonNull
    private String gender;
    
    private Location location = new Location();
    
    @NonNull
    private Inventory inventory;
    
    private Integer reportCounts = 0;
    
    @Setter
    private boolean isTraitor = false;

    public void addReport() {
        this.reportCounts++;
    }
}
