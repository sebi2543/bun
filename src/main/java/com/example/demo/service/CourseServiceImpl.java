package com.example.demo.service;

import com.example.demo.dto.CourseDTO;
import com.example.demo.entity.Course;
import com.example.demo.exception.InvalidTitle;
import com.example.demo.mapper.CourseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    CourseMapper courseMapper;
    public  void checkTitle(String title) throws InvalidTitle {
            if (title.length()==0)
                throw new InvalidTitle();
            if (title.length()>1 && title.length()<=3)
                throw  new InvalidTitle();
    }

    @Override
    public List<CourseDTO>CourseToDOS(List<Course> courses) {
       List<CourseDTO> courseDTOS=new ArrayList<>();
       for (Course course : courses)
           courseDTOS.add(courseMapper.courseToDTO(course));
       return courseDTOS;
    }


}
