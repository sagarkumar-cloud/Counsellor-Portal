package com.sagar.service;


import com.sagar.dto.CounsellorDto;
import com.sagar.dto.DashBoardResponse;
import com.sagar.entity.Counsellor;

public interface CounsellorService {

    public boolean register(CounsellorDto counsellorDto);

    public Counsellor login(String email,String password);

    public DashBoardResponse getResponse(Integer counsellorId);

    public Counsellor checkEmail(String email);
}
