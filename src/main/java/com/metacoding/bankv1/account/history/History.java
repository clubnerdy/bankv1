package com.metacoding.bankv1.account.history;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@NoArgsConstructor
@Getter
@Table(name = "history_tb")
@Entity
public class History {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer withdrawNumber; // 1111
    private Integer depositNumber; // 2222
    private Integer amount; // 100원
    private Integer withdrawBalance; // 그 시점에 잔액 => 900원
    private Integer depositBalance; // 그 시점에 잔액 => 900원
    private Timestamp createdAt;
}
