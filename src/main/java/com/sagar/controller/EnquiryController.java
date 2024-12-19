package com.sagar.controller;

import com.sagar.entity.EnquiryStudent;
import com.sagar.service.EnquiryService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EnquiryController {

    private EnquiryService enquiryService;

    public EnquiryController(EnquiryService enquiryService) {
        this.enquiryService = enquiryService;
    }

    @GetMapping("/enquiry")
      public String addEnquiry(Model model){
          EnquiryStudent enquiryObj = new EnquiryStudent();
          model.addAttribute("enquiry",enquiryObj);
        return"enquiry_form";
      }

      @PostMapping("/addEnq")
      public String handleAddEnquiry(Model model, EnquiryStudent enquiry, HttpServletRequest request) throws Exception {
          HttpSession session = request.getSession(false);
          Integer counsellorId=(Integer) session.getAttribute("counsellorId");

          boolean isSaved = enquiryService.addEnquiry(enquiry, counsellorId);
          if(isSaved){
              model.addAttribute("sMsg","enquiry added..");
          }else{
              model.addAttribute("eMsg","enquiry adding failed..!!");
          }

          return "enquiry_form";
      }
}
