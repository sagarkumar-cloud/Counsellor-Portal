package com.sagar.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DashBoardResponse {

    private  Integer totalEnquiry;
    private Integer openEnquiry;
    private Integer enrolledEnquiry;
    private Integer lostEnquiry;
}
