package com.example.basic.domain.entity;

import com.example.basic.type.SuperCarType;
import com.sun.istack.NotNull;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter @Setter @ToString
@Table(name = "TBL_SUPER_CAR")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SuperCar {
    @Id @GeneratedValue
    private Long id;
    @Enumerated(value = EnumType.STRING)
    @NotNull private SuperCarType superCarType;
    @NotNull private String superCarName;
    @NotNull private String superCarColor;
    private Double superCarPrice;
    private LocalDateTime superCarReleaseDate;

    @Builder
    public SuperCar(SuperCarType superCarType, String superCarName, String superCarColor, Double superCarPrice, LocalDateTime superCarReleaseDate) {
        this.superCarType = superCarType;
        this.superCarName = superCarName;
        this.superCarColor = superCarColor;
        this.superCarPrice = superCarPrice;
        this.superCarReleaseDate = superCarReleaseDate;
    }
}












