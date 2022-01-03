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

    //    private final BoardServiceImpl boardService;

//    @Autowired
//    public BoardController(BoardServiceImpl boardService) {
//        this.boardService = boardService;
//    }
//
//
//    @GetMapping("/test")
//    public Optional<Board> boardSel(Board board) {
//        return boardService.boardSelect(board.getSeq());
//    }

//    @PostMapping("/test/{id}")
//    public Board boardIns(@PathVariable int id) {
//        Board board = new Board();
//        boardService.boardInsert(id);
//        return board;
//    }

//    @RequestMapping(path = "/hi", method = RequestMethod.GET) // get, put, delete, post 다 동작함
//    public String hi(){
//        return "hi";
//    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello Spring Boot";
    }

    // http://localhost:8080/path-variable/{name}
    // @PathVariable(name = "name") -> /path-variable/{name} -> name 값 전달
    @GetMapping("/path-variable/{name}")
    public String pathVariable(@PathVariable(name = "name") String name) {
        System.out.println("PathVariable " + name);
        return name;
    }



    @GetMapping("query-param3")
    public String queryParam(Board board){
        return board.toString();
    }



    /**
     * Create Read Update Delete
     */

    // http://localhost:8080/board-read/1
    @GetMapping("/board-read/{id}")
    public Optional<Board> boardRead(@PathVariable(name = "id") int id){
        Optional<Board> board = boardService.boardSelect(id);
        return board;
    }



    /*
        {
        "seq" : "1",
        "title" : "제목",
        "writer" : "작성자",
        "content" : "1234"
        }
    */
    // Create
    // http://localhost:8080/board-create"
    @PostMapping("/board-create")
    public void postTest(@RequestBody Board board){
        boardService.boardSave(board);
    }




/*
    private int seq;

    private String title;

    private String writer;

    private String content;

    private Date regDate;

    private int cnt;
*/

}
