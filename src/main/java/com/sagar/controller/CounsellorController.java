package com.sagar.controller;

import com.sagar.dto.CounsellorDto;
import com.sagar.service.CounsellorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public class CounsellorController {

    private CounsellorService counsellorService;

    public CounsellorController(CounsellorService counsellorService) {
        this.counsellorService = counsellorService;
    }

    public String registerCounsellor(CounsellorDto counsellorDto, Model model){
       boolean isRegister= counsellorService.register(counsellorDto);
        if(isRegister){
            return "Congrats,You have successfully registered in our institute";
        }else{
            return "please, give unique email";
        }
    }
}
