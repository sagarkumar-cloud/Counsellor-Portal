package com.sagar.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ViewEnqsFilterRequest {

    private String classMode;
    private String courseName;
    private String status;
}
