package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BasicProfileDTO {

    @NotBlank
    @Size(min = 3,max = 15)
    private String linkedin;

    @NotBlank
    @Size(min = 3,max = 15)
    private String youtube;
}
