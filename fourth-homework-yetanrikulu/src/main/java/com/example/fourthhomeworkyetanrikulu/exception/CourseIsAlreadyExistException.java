package com.example.fourthhomeworkyetanrikulu.exception;

public class CourseIsAlreadyExistException extends RuntimeException {
    public CourseIsAlreadyExistException() {
        super("Course is already exist.");
    }
}
