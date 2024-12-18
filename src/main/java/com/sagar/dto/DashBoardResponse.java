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

    public Integer getTotalEnquiry() {
        return totalEnquiry;
    }

    public void setTotalEnquiry(Integer totalEnquiry) {
        this.totalEnquiry = totalEnquiry;
    }

    public Integer getOpenEnquiry() {
        return openEnquiry;
    }

    public void setOpenEnquiry(Integer openEnquiry) {
        this.openEnquiry = openEnquiry;
    }

    public Integer getEnrolledEnquiry() {
        return enrolledEnquiry;
    }

    public void setEnrolledEnquiry(Integer enrolledEnquiry) {
        this.enrolledEnquiry = enrolledEnquiry;
    }

    public Integer getLostEnquiry() {
        return lostEnquiry;
    }

    public void setLostEnquiry(Integer lostEnquiry) {
        this.lostEnquiry = lostEnquiry;
    }
}
