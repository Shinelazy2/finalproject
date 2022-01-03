package com.fastcampus.finalproject.repository;

import com.fastcampus.finalproject.model.Board;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository extends CrudRepository <Board, Integer> {
}
