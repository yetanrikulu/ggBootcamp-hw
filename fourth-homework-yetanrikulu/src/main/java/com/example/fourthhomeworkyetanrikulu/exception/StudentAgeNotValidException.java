package com.example.fourthhomeworkyetanrikulu.exception;

public class StudentAgeNotValidException extends RuntimeException {

    public StudentAgeNotValidException() {
        super("Student age should be between 18 - 40");
    }
}
