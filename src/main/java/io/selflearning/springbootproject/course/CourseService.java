package io.selflearning.springbootproject.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class CourseService {

    @Autowired
    CourseRepository courseRepository;

    public List<Course> getAllCourse(String topicId){
        List<Course> courses =new ArrayList<>();
        courseRepository.findByTopicId(topicId).forEach(courses::add);
        return  courses;
    }

    public Course getCourse(String id){
        return courseRepository.findById(id).stream().findFirst().get();
    }

    public void addCourse(Course course){
        courseRepository.save(course);
    }

    public void updateCourse(Course course){
        courseRepository.save(course);
    }

    public void deleteCourse(String id){
        courseRepository.deleteById(id);
    }
}
