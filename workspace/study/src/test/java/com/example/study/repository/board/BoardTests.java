package com.example.study.repository.board;

import com.example.study.entity.Board;
import com.example.study.repository.BoardDAO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
@Rollback(false)
@Slf4j
public class BoardTests {
    @Autowired
    private BoardDAO boardDAO;

    @Test
    public void saveTest(){
        Board board = new Board();
        board.setBoardTitle("테스트 제목1");
        board.setBoardContent("테스트 내용1");
        boardDAO.save(board);
    }

    @Test
    public void findById(){
        boardDAO.findById(1L).map(Board::toString).ifPresent(log::info);
    }

}
