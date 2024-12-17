package com.sagar.controller;

import com.sagar.service.EnquiryService;
import org.springframework.stereotype.Controller;

@Controller
public class EnquiryController {

    private EnquiryService enquiryService;

    public EnquiryController(EnquiryService enquiryService) {
        this.enquiryService = enquiryService;
    }


}
