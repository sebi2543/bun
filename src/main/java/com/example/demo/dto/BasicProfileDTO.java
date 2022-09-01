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

    @NotBlank(message ="linkedIn can contain only letters")
    @Size(min = 3,max = 15,message = "linked must be between 3 and 15")
    private String linkedin;

    @NotBlank(message ="youtube can contain only letters")
    @Size(min = 3,max = 15,message = "youtube must be between 3 and 15")
    private String youtube;
}
