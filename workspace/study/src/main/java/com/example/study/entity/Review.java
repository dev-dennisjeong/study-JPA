package com.example.study.entity;

import com.sun.istack.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@Table(name = "TBL_REVIEW")
public class Review {
    @Id @GeneratedValue @EqualsAndHashCode.Include
    @NotNull private Long id;
    @NotNull private String reviewContent;
    @NotNull private int ratingPoint;

}
