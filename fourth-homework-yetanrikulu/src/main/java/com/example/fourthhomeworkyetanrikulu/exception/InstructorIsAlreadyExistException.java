package com.example.fourthhomeworkyetanrikulu.exception;

public class InstructorIsAlreadyExistException extends RuntimeException {
    public InstructorIsAlreadyExistException() {
        super("Instructor is already exist");
    }
}
