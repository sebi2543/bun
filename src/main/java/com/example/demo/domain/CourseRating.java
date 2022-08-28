package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseRating {
    public long headcount;
    public int sum;

    public void addGrade(long grade){
        headcount++;
        sum+=grade;
    }

    public float calculateAverage(){
        return (float)headcount/sum;
    }
}
