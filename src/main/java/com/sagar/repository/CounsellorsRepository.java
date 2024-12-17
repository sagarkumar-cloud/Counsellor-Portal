package com.sagar.repository;

import com.sagar.entity.Counsellor;
import com.sagar.entity.EnquiryStudent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CounsellorsRepository extends JpaRepository<Counsellor,Integer> {

    public Counsellor findByEmail(String email);

    public Counsellor findByEmailAndPassword(String email,String password);

}
