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
    private List<Course> courses = new ArrayList<>(Arrays.asList(
            new Course("springboot", "Spring boot", "Spring boot description"),
            new Course("javascript", "Javascript", "Javascript description"),
            new Course("reactjs", "React JS", "ReactJS Description")
    ));
    public List<Course> getAllCourse(){
        List<Course> courses =new ArrayList<>();
        courseRepository.findAll().forEach(courses::add);
        return  courses;
    }

    public Course getCourse(String id){
        return courseRepository.findById(id).stream().findFirst().get();
    }

    public void addCourse(Course course){
        courseRepository.save(course);
    }

    public void updateCourse(String id, Course course){
        courseRepository.save(course);
    }

    public void deleteCourse(String id){
        courseRepository.deleteById(id);
    }
}
