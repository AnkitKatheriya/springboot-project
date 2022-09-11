package io.selflearning.springbootproject.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {

    @Autowired
    CourseService courseService;

    @RequestMapping("/courses")
    public List<Course> getAllTopics(){
        return courseService.getAllCourse();
    }

    @RequestMapping("/courses/{topicId}")
    public Course getTopic(@PathVariable(value = "topicId") String id){
        return courseService.getCourse(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/courses")
    public void addTopic(@RequestBody Course course){
        courseService.addCourse(course);
    }

    @RequestMapping(method = RequestMethod.PUT, value="/courses/{id}")
    public  void updateTopic(@PathVariable String id, @RequestBody Course course){
        courseService.updateCourse(id, course);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/courses/{id}")
    public void deleteTopic(@PathVariable String id){
        courseService.deleteCourse(id);
    }
}
