package io.selflearning.springbootproject.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TopicService {

    @Autowired
    TopicRepository topicRepository;
    private List<Topic> topics = new ArrayList<>(Arrays.asList(
            new Topic("springboot", "Spring boot", "Spring boot description"),
            new Topic("javascript", "Javascript", "Javascript description"),
            new Topic("reactjs", "React JS", "ReactJS Description")
    ));
    public List<Topic> getAllTopic(){
        //return topics;
        List<Topic> topics =new ArrayList<>();
        topicRepository.findAll().forEach(topics::add);
        return  topics;
    }

    public Topic getTopic(String id){
        //return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
        return topicRepository.findById(id).stream().findFirst().get();
    }

    public void addTopic(Topic topic){
        //topics.add(topic);
        topicRepository.save(topic);
    }

    public void updateTopic(String id, Topic topic){
        /*for(int i = 0; i < topics.size(); i++){
            Topic t = topics.get(i);
            if(t.getId().equals(id)){
                topics.set(i, topic);
                return;
            }
        }*/
        topicRepository.save(topic);
    }

    public void deleteTopic(String id){
        //topics.removeIf(t -> t.getId().equals(id));
        topicRepository.deleteById(id);
    }
}
