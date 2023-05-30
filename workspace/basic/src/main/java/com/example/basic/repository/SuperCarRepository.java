package com.example.basic.repository;

import com.example.basic.domain.entity.SuperCar;
import com.example.basic.type.SuperCarType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface SuperCarRepository extends JpaRepository<SuperCar, Long> {
//    조회
    public List<SuperCar> findBySuperCarName(String superCarName);
    public List<SuperCar> findBySuperCarColor(String superCarColor);

    public int countAllBySuperCarType(SuperCarType superCarType);
    public List<SuperCar> findAllBySuperCarReleaseDate(LocalDateTime superCarReleaseDate);
    public List<SuperCar> findAllBySuperCarReleaseDateBetween(LocalDateTime startDate, LocalDateTime endDate);
    @Query("select s from SuperCar s where s.superCarType = com.example.basic.type.SuperCarType")
    public List<SuperCar> findAllByLamborghini();
    public List<SuperCar> findByNameLike(String name);

    public void deleteBySuperCarPriceIsLessThanEqual(Double SuperCarPrice);
}
