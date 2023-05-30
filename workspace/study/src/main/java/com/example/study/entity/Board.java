package com.example.study.entity;

import com.example.study.audit.Period;
import com.sun.istack.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter @ToString(exclude = "reviews")
@Table(name = "TBL_BOARD")
public class Board extends Period {
    @Id @GeneratedValue @EqualsAndHashCode.Include
    private Long id;
    @NotNull private String boardTitle;
    @NotNull private String boardContent;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<Review> reviews = new ArrayList<>();
}
