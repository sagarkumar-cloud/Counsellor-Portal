package com.sagar.controller;

import com.sagar.dto.ViewEnqsFilterRequest;
import com.sagar.entity.EnquiryStudent;
import com.sagar.service.EnquiryService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class EnquiryController {

    //ModelAttribute is used to send the object to ui

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
      public String handleAddEnquiry(Model model, @ModelAttribute("enquiry") EnquiryStudent enquiry, HttpServletRequest request) throws Exception {
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

      @GetMapping("/viewEnq")
     public String viewEnquiry(Model model,HttpServletRequest request){
         HttpSession session = request.getSession(false);
         Integer counsellorId=(Integer)session.getAttribute("counsellorId");

         List<EnquiryStudent> allEnquiry = enquiryService.getAllEnquiry(counsellorId);
         model.addAttribute("enquiry",allEnquiry);

          ViewEnqsFilterRequest viewEnqsFilterRequest=new ViewEnqsFilterRequest();
          model.addAttribute("viewEnqsFilterRequest",viewEnqsFilterRequest);
         return "view_enquiry";
     }

     @PostMapping("/view-enquiries")
     public String handleFilterRequest(HttpServletRequest request,Model model,ViewEnqsFilterRequest viewEnqsFilterRequest){
         HttpSession session = request.getSession(false);
         Integer counsellorId=(Integer)session.getAttribute("counsellorId");

         List<EnquiryStudent> filteredEnqs = enquiryService.filterAllEnquiry(viewEnqsFilterRequest, counsellorId);

         model.addAttribute("enquiry",filteredEnqs);
         return "view_enquiry";
     }
}
