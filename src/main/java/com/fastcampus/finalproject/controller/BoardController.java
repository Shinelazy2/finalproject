package com.fastcampus.finalproject.controller;

import com.fastcampus.finalproject.model.Board;
import com.fastcampus.finalproject.repository.BoardRepository;
import com.fastcampus.finalproject.service.BoardServiceImpl;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
import java.util.Map;
import java.util.Optional;

@RestController
public class BoardController {

    private final BoardServiceImpl boardService;

    @Autowired
    public BoardController(BoardServiceImpl boardService) {
        this.boardService = boardService;
    }

    // Read
    // http://localhost:8080/board-read/1
    @GetMapping("/board-read/{id}")
    public Board boardRead(@PathVariable int id){
        return boardService.boardSelect(id);

    }

    // Create
    /*
        {
        "seq" : "1",
        "title" : "제목",
        "writer" : "작성자",
        "content" : "1234"
        }
    */
    // http://localhost:8080/board-create"
    @PostMapping("/board-create")
    public void boardCreate(@RequestBody Board board){
        boardService.boardSave(board);
    }

    // Update
    /*
    {
     "title" : "변경됨",
     "content" : "변경됬음"
     }
     */
    // http://localhost:8080/board-update/1
    @PutMapping("/board-update/{id}")
    public void boardPut(@PathVariable int id,@RequestBody Board board) {
        System.out.println(board);
        boardService.boardUpdate(id, board);
    }

    //Delete
    // http://localhost:8080/board-delete/2
    @DeleteMapping("/board-delete/{id}")
    public void boardDel(@PathVariable int id){
        boardService.boardDelete(id);
    }



}
