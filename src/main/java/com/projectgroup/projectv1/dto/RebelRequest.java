package com.projectgroup.projectv1.dto;

import com.projectgroup.projectv1.model.inventory.Inventory;
import com.projectgroup.projectv1.utils.validators.gender.Gender;
import lombok.*;

import javax.validation.constraints.*;


@Getter
@AllArgsConstructor
public class RebelRequest {
    @NotNull @NotBlank @Size(min = 2, max = 50)
    private String name;

    @Positive @Max(150)
    private Integer age;

    @Gender
    private String gender;

    @NotNull
    private Inventory inventory;
}
