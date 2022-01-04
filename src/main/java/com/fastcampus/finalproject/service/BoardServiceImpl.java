package com.fastcampus.finalproject.service;

import com.fastcampus.finalproject.model.Board;
import com.fastcampus.finalproject.repository.BoardRepository;
import org.hibernate.boot.model.naming.IllegalIdentifierException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class BoardServiceImpl {

    private final BoardRepository boardRepository;

    @Autowired
    public BoardServiceImpl(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    // get
    @Transactional
    public Board boardSelect(int id){
        return boardRepository.findById(id).orElseThrow(
                () -> new IllegalIdentifierException("해당 게시글이 없습니다.")
        );
    }

    // post
    @Transactional
    public void boardSave(Board board){
        boardRepository.save(board);
    }

    //delete
    @Transactional
    public void boardDelete(int id){
        boardRepository.deleteById(id);
    }

    //update
    // 제목, 내용만 수정
    @Transactional
    public void boardUpdate(int id, Board requestBoard){
        Board board = boardRepository.findById(id).orElseThrow(
                () -> new IllegalIdentifierException("해당 게시글이 없습니다.")
        );

        board.setTitle(requestBoard.getTitle());
        board.setContent(requestBoard.getContent());
        System.out.println(board);
    }

}
