package com.example.fourthhomeworkyetanrikulu.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExceptionTransactionLogger {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    LocalDate localDate;
    String message;
}
