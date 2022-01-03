package com.fastcampus.finalproject.service;

import com.fastcampus.finalproject.model.Board;
import com.fastcampus.finalproject.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BoardServiceImpl {
    // impl

    private final BoardRepository boardRepository;

    @Autowired
    public BoardServiceImpl(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    public Optional<Board> boardSelect(int id){
        return boardRepository.findById(id);
    }

    public void boardSave(Board board){
        boardRepository.save(board);
    }

    public void boardInsert(int id){
        boardRepository.findById(id);
    }

    public void boardDelete(int id){
        boardRepository.findById(id);
    }

}
