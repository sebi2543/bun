package com.example.demo.service;

import com.example.demo.exception.InvalidTitle;
import org.springframework.stereotype.Service;

@Service
public interface CourseService {

    void checkTitle(String title) throws InvalidTitle;

}
