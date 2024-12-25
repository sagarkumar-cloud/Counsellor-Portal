package com.sagar.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CounsellorDto {
    private String name;
    private String email;
    private Long phno;
    private String password;

}
