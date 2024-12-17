package com.sagar.service;
import java.util.List;

import com.sagar.dto.ViewEnqsFilterRequest;
import com.sagar.entity.Counsellor;
import com.sagar.entity.EnquiryStudent;

public interface EnquiryService {

    public boolean addEnquiry(EnquiryStudent enquiryStudent,Integer counsellorId) throws Exception;

    public List<EnquiryStudent> getAllEnquiry(Integer counsellorId);

    public List<EnquiryStudent> filterAllEnquiry(ViewEnqsFilterRequest request,Integer counsellorId);

    public EnquiryStudent editEnquiry(Integer enquiryId);
}
