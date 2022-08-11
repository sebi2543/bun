package com.example.demo.service;

import com.example.demo.exception.InvalidTitle;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl implements CourseService {

    public  void checkTitle(String title) throws InvalidTitle {
            if (title.length()==0)
                throw new InvalidTitle();
            if (title.length()>0 && title.length()<=3)
                throw  new InvalidTitle();
    }
}
