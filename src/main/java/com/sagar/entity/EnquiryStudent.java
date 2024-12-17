package com.sagar.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@Setter
@Getter
@AllArgsConstructor
@Table(name="enquiry_tbl")
public class EnquiryStudent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer enquiryId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false,unique = true)
    private Long phno;


    private String classMode;
    private String courseName;
    private String status;

    @UpdateTimestamp
    private LocalDate updateDate;

    @CreationTimestamp
    private LocalDate createdDate;

    @ManyToOne
    @JoinColumn(name="counsellor_id")
    private Counsellor counsellor;
}
