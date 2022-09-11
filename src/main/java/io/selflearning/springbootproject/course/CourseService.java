package io.selflearning.springbootproject.course;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class CourseService {

    private List<Course> courses = new ArrayList<>(Arrays.asList(
            new Course("springboot", "Spring boot", "Spring boot description"),
            new Course("javascript", "Javascript", "Javascript description"),
            new Course("reactjs", "React JS", "ReactJS Description")
    ));
    public List<Course> getAllCourse(){
        return courses;
    }

    public Course getCourse(String id){
        return courses.stream().filter(t -> t.getId().equals(id)).findFirst().get();
    }

    public void addCourse(Course course){
        courses.add(course);
    }

    public void updateCourse(String id, Course course){
        for(int i = 0; i < courses.size(); i++){
            Course t = courses.get(i);
            if(t.getId().equals(id)){
                courses.set(i, course);
                return;
            }
        }
    }

    public void deleteCourse(String id){
        courses.removeIf(t -> t.getId().equals(id));
    }
}
