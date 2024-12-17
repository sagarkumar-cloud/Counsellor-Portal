package com.sagar.service;

import com.sagar.dto.CounsellorDto;
import com.sagar.dto.DashBoardResponse;
import com.sagar.entity.Counsellor;
import com.sagar.entity.EnquiryStudent;
import com.sagar.repository.CounsellorsRepository;
import com.sagar.repository.EnquiryStudentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CounsellorServiceImpl implements CounsellorService{

    private CounsellorsRepository counsellorRepository;
    private ModelMapper modelMapper;
    private EnquiryStudentRepository enquiryRepository;

    public CounsellorServiceImpl(CounsellorsRepository counsellorRepository,
                                 ModelMapper modelMapper,
                                 EnquiryStudentRepository enquiryRepository){
        this.counsellorRepository=counsellorRepository;
        this.modelMapper=modelMapper;
        this.enquiryRepository=enquiryRepository;
    }


    @Override
    public boolean register(CounsellorDto counsellorDto) {
        Counsellor counsellor = modelMapper.map(counsellorDto,Counsellor.class);
        Counsellor newCounsellor= counsellorRepository.save(counsellor);
        if(null != newCounsellor.getCounsellorId()){
            return true;
        }
        return false;
    }

    @Override
    public Counsellor login(String email, String password) {
        return counsellorRepository.findByEmailAndPassword(email, password);
    }

    @Override
    public Counsellor checkEmail(String email) {
        return counsellorRepository.findByEmail(email);
    }

    @Override
    public DashBoardResponse getResponse(Integer counsellorId) {
        DashBoardResponse response = new DashBoardResponse();

        List<EnquiryStudent> allEnq = enquiryRepository.findByEnquiryByCounsellorId(counsellorId);

        int totalEnq= allEnq.size();

         int enrolled= allEnq.stream()
                    .filter(enq -> enq.equals("Enrolled"))
                    .collect(Collectors.toList())
                    .size();

         int lost= allEnq.stream()
                    .filter(enq->enq.equals("Lost"))
                    .collect(Collectors.toList())
                    .size();

          int open= allEnq.stream()
                    .filter(enq->enq.equals("Open"))
                    .collect(Collectors.toList())
                    .size();
        response.setOpenEnquiry(open);
        response.setLostEnquiry(lost);
        response.setEnrolledEnquiry(enrolled);
        response.setTotalEnquiry(totalEnq);
        return response;
    }

}

