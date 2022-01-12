package graphqlspringbootstarter.graphqlspringbootstarter.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import graphqlspringbootstarter.graphqlspringbootstarter.pojo.Speaker;
import graphqlspringbootstarter.graphqlspringbootstarter.pojo.Talk;
import graphqlspringbootstarter.graphqlspringbootstarter.service.TalkService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class SpeakerResolver implements GraphQLResolver<Speaker> {
    @Resource
    private TalkService talkService;

    public List<Talk> talks(Speaker speaker) {
        return talkService.findAllTalksBySpeaker(speaker);

    }
}
