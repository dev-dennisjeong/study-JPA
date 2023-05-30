package com.example.basic.repository;

import com.example.basic.domain.entity.SuperCar;
import com.example.basic.type.SuperCarType;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
@Rollback(false)
@Slf4j
public class SuperCarRepositoryTests {
    @Autowired
    private SuperCarRepository superCarRepository;

//    등록
    @Test
    public void saveTest(){
        SuperCar superCar1 = SuperCar.builder()
                .superCarName("애마1")
                .superCarColor("black")
                .superCarPrice(1000000000D)
                .superCarType(SuperCarType.BENTLEY)
                .superCarReleaseDate(LocalDateTime.now())
                .build();

        SuperCar superCar2 = SuperCar.builder()
                .superCarName("애마2")
                .superCarColor("red")
                .superCarPrice(500000000D)
                .superCarType(SuperCarType.FERRARI)
                .superCarReleaseDate(LocalDateTime.now())
                .build();

        SuperCar superCar3 = SuperCar.builder()
                .superCarName("애마3")
                .superCarColor("yellow")
                .superCarPrice(300000000D)
                .superCarType(SuperCarType.LAMBORGHINI)
                .superCarReleaseDate(LocalDateTime.now())
                .build();

        SuperCar superCar4 = SuperCar.builder()
                .superCarName("애마4")
                .superCarColor("white")
                .superCarPrice(80000000D)
                .superCarType(SuperCarType.HYUNDAI)
                .superCarReleaseDate(LocalDateTime.now())
                .build();

        List<SuperCar> superCars = new ArrayList<>(Arrays.asList(superCar1, superCar2, superCar3, superCar4));
        superCarRepository.saveAll(superCars);

    }

//    조회
    @Test
    public void findByIdTest(){
        superCarRepository.findById(1L).map(SuperCar::toString).ifPresent(log::info);
    }

    @Test
    public void findBySuperCarNameTest(){
        assertThat(superCarRepository.findBySuperCarName("애마1")).hasSize(1);
    }

    @Test
    public void findBySuperCarColorTest(){
        assertThat(superCarRepository.findBySuperCarColor("red")).hasSize(1);
    }

    @Test
    public void countAllBySuperCarTypeTest(){
        superCarRepository.countAllBySuperCarType(SuperCarType.BENTLEY);
    }

    @Test
    public void findAllBySuperCarReleaseDateTest(){
        assertThat(superCarRepository.findAllBySuperCarReleaseDate(LocalDateTime.of(2023, 04, 24, 14, 44, 27))).hasSize(3);
    }

    @Test
    public void findAllBySuperCarReleaseDateBetweenTest(){
        assertThat(superCarRepository.findAllBySuperCarReleaseDateBetween(LocalDateTime.of(2023, 04, 01, 00, 00, 00), LocalDateTime.of(2023, 04, 30, 00, 00, 00))).hasSize(3);
    }

    @Test
    public void deleteBySuperCarPriceIsLessThanEqualTest(){
        superCarRepository.deleteBySuperCarPriceIsLessThanEqual(100000000D);
    }
}
