package com.sagar.service;

import com.sagar.dto.ViewEnqsFilterRequest;
import com.sagar.entity.Counsellor;
import com.sagar.entity.EnquiryStudent;
import com.sagar.repository.CounsellorsRepository;
import com.sagar.repository.EnquiryStudentRepository;
import io.micrometer.common.util.StringUtils;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnquiryServiceImpl implements EnquiryService{

    private EnquiryStudentRepository enquiryRepository;
    private CounsellorsRepository counsellorsRepository;

    public EnquiryServiceImpl(EnquiryStudentRepository enquiryRepository, CounsellorsRepository counsellorsRepository) {
        this.enquiryRepository = enquiryRepository;
        this.counsellorsRepository = counsellorsRepository;
    }

    @Override
    public boolean addEnquiry(EnquiryStudent enquiryStudent, Integer counsellorId) throws Exception {
        Counsellor counsellor = counsellorsRepository.findById(counsellorId).orElse(null);
        if(null != counsellor.getCounsellorId()){
            throw new Exception("Counsellor Not found..!");
        }

        //associating counsellor to enquiry
           enquiryStudent.setCounsellor(counsellor);
        EnquiryStudent save = enquiryRepository.save(enquiryStudent);
        if(null != save.getEnquiryId())
            return true;
        return false;
    }

    @Override
    public List<EnquiryStudent> getAllEnquiry(Integer counsellorId) {
        return enquiryRepository.findByEnquiryByCounsellorId(counsellorId);
    }

    @Override
    public List<EnquiryStudent> filterAllEnquiry(ViewEnqsFilterRequest request, Integer counsellorId) {
        EnquiryStudent enq = new EnquiryStudent();

        //means status not null and Empty
        if(StringUtils.isNotEmpty(request.getStatus())){
            enq.setStatus(request.getStatus());
        }

        if(StringUtils.isNotEmpty(request.getClassMode())){
            enq.setClassMode(request.getClassMode());
        }

        if(StringUtils.isNotEmpty(request.getCourseName())){
            enq.setCourseName(request.getCourseName());
        }

        Counsellor counsellor = counsellorsRepository.findById(counsellorId).orElse(null);
        enq.setCounsellor(counsellor);

        Example<EnquiryStudent> enquiryStudentExample = Example.of(enq);
        List<EnquiryStudent> enqList = enquiryRepository.findAll(enquiryStudentExample);
        return enqList;
    }

    @Override
    public EnquiryStudent editEnquiry(Integer enquiryId) {
        return enquiryRepository.findById(enquiryId).orElse(null);
    }
}
