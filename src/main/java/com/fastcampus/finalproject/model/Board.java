package com.fastcampus.finalproject.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;


/**
 * SEQ NUMBER(5) PRIMARY KEY,
 * TITLE VARCHAR2(200) NOT NULL,
 * WRITER VARCHAR2(20) NOT NULL,
 * CONTENT VARCHAR2(2000) NOT NULL,
 * REGDATE DATE DEFAULT SYSDATE,
 * CNT NUMBER(5) DEFAULT 0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "BOARD")
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
    @Column(name = "SEQ", nullable = false, length = 5)
    private int seq;

    @Column(name = "TITLE", nullable = false, length = 200)
    private String title;

    @Column(name = "WRITER", nullable = false, length = 20)
    private String writer;

    @Column(name = "CONTENT", nullable = false, length = 2000)
    private String content;

    @CreationTimestamp // SYSDATE = oracle
    @Column(name = "REGDATE", nullable = false, length = 20)
    private Date regDate;

    @Column(name="CNT",nullable = true, length = 5)
    @ColumnDefault("0")
    private int cnt;


}
