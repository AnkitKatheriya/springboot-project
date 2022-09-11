package io.selflearning.springbootproject.topic;

import org.springframework.stereotype.Service;

import java.sql.Array;
import java.util.Arrays;
import java.util.List;

@Service
public class TopicService {

    private List<Topic> topics = Arrays.asList(
            new Topic("springboot", "Spring boot", "Spring boot description"),
            new Topic("javascript", "Javascript", "Javascript description"),
            new Topic("reactjs", "React JS", "ReactJS Description")
    );
    public List<Topic> getAllTopic(){
        return topics;
    }
}
