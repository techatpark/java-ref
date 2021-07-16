package com.techatpark.javapractice.controller;

import com.techatpark.javapractice.repository.PracticeRepository;

public class PracticeController {

    private PracticeRepository practiceRepository;
    public void createPractice(String name, String description) {
        practiceRepository.createPractice(name, description);
    }
}
