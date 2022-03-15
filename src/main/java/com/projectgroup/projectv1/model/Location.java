package com.projectgroup.projectv1.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Getter
@NoArgsConstructor
public class Location {
    @NotBlank
    private String latitude = null;
    @NotBlank
    private String longitude = null;
    @NotBlank @Size(min = 2, max = 50)
    private String baseName = null;
}
