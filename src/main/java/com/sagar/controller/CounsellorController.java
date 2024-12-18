package com.sagar.controller;

import com.sagar.dto.CounsellorDto;
import com.sagar.dto.DashBoardResponse;
import com.sagar.entity.Counsellor;
import com.sagar.service.CounsellorService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CounsellorController {

    private CounsellorService counsellorService;

    public CounsellorController(CounsellorService counsellorService) {
        this.counsellorService = counsellorService;
    }

    @GetMapping("/")
    public String index(Model model){
        Counsellor cObj= new Counsellor();
        model.addAttribute("counsellor",cObj);
        return "index";
    }

    @PostMapping("/login")
    public String handleLogin(Model model, HttpServletRequest request,Counsellor counsellor){

        Counsellor login = counsellorService.login(counsellor.getEmail(), counsellor.getPassword());
        if(login == null){
            model.addAttribute("eMsg","Invalid Credential");
        }else{
            HttpSession session = request.getSession(true);
            session.setAttribute("counsellorId",login.getCounsellorId());

            DashBoardResponse dashboardResponse = counsellorService.getDashboardResponse(login.getCounsellorId());
            model.addAttribute("dashboardInfo",dashboardResponse);

            return "dashboard";
        }
         return "index";
    }

    @GetMapping("/logout")
    public String logout(Model model,HttpServletRequest request){
        HttpSession session = request.getSession(false);
        session.invalidate();
        return "redirect:/";
    }

    @GetMapping("/register")
    public String register(Model model){
        Counsellor counsellor=new Counsellor();
        model.addAttribute("counsellor",counsellor);
        return"register";
    }

    @PostMapping("/register")
    public String handleRegisterPage(Counsellor counsellor,Model model){
        Counsellor coun = counsellorService.checkEmail(counsellor.getEmail());
        if(coun != null){
            model.addAttribute("eMsg","Email already registered..");
            return "register";
        }
        boolean register = counsellorService.register(counsellor);
        if(register){
            model.addAttribute("sMsg","success");
        }else{
            model.addAttribute("eMsg","unsuccessfully");
        }
        return "register";
    }
}
