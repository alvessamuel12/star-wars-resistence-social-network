package com.projectgroup.projectv1.dto;

import com.projectgroup.projectv1.utils.validators.gender.Gender;
import lombok.Getter;

import javax.validation.constraints.*;


@Getter
public class RebelRequest {
    @NotNull @NotBlank @Size(min = 2, max = 50)
    private String name;

    @Positive @Max(150)
    private Integer age;

    @Gender
    private String gender;
}
