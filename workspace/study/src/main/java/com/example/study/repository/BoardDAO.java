package com.example.study.repository;

import com.example.study.entity.Board;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Optional;

@Repository
public class BoardDAO {
    @PersistenceContext
    private EntityManager entityManager;

//    추가
    public Board save(Board board){
        entityManager.persist(board);
        return board;
    }

//    조회
    public Optional<Board> findById(Long id){
        String query = "select b from Board b join fetch b.reviews where b.id = :id";
        return Optional.ofNullable(entityManager.createQuery(query, Board.class)
                .setParameter("id", id)
                .getSingleResult());
    }

}
