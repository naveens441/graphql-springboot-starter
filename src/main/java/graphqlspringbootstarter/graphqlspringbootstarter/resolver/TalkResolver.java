package graphqlspringbootstarter.graphqlspringbootstarter.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import graphqlspringbootstarter.graphqlspringbootstarter.pojo.Speaker;
import graphqlspringbootstarter.graphqlspringbootstarter.pojo.Talk;
import graphqlspringbootstarter.graphqlspringbootstarter.service.SpeakerService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class TalkResolver implements GraphQLResolver<Talk> {
    @Resource
    private SpeakerService speakerService;
    public List<Speaker> speakers(Talk talk){
        return  speakerService.findAllSpeakersForTalk(talk);
    }

}
