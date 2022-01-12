package graphqlspringbootstarter.graphqlspringbootstarter.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import graphqlspringbootstarter.graphqlspringbootstarter.pojo.Attendee;
import graphqlspringbootstarter.graphqlspringbootstarter.pojo.Speaker;
import graphqlspringbootstarter.graphqlspringbootstarter.pojo.Talk;
import graphqlspringbootstarter.graphqlspringbootstarter.service.AttendeeService;
import graphqlspringbootstarter.graphqlspringbootstarter.service.SpeakerService;
import graphqlspringbootstarter.graphqlspringbootstarter.service.TalkService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class Query implements GraphQLQueryResolver {
    @Resource
    private AttendeeService attendeeService;
    @Resource
    private SpeakerService speakerService;
    @Resource
    private TalkService talkService;
    public List<Talk> allTalks() {
        return talkService.findAll();
    }

    public List<Speaker> allSpeakers() {
        return speakerService.findAll();
    }

    public List<Attendee> allAttendees() {
        return attendeeService.findAll();
    }

    public List<Object> allAll(){
        List list1=talkService.findAll();
        List list2=speakerService.findAll();
        list1.addAll(list2);
        return list1;
    }

}
