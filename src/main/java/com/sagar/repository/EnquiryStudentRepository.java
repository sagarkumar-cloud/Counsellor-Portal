package com.sagar.repository;

import com.sagar.entity.EnquiryStudent;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EnquiryStudentRepository extends JpaRepository<EnquiryStudent,Integer> {

    @Query(value = "select * from enquiry_tbl where counsellor_id=:counsellorId" , nativeQuery = true)
    public List<EnquiryStudent> findByEnquiryByCounsellorId(Integer counsellorId);
}
