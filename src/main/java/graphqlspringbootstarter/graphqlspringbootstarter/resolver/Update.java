package graphqlspringbootstarter.graphqlspringbootstarter.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import graphqlspringbootstarter.graphqlspringbootstarter.service.SpeakerService;
import lombok.RequiredArgsConstructor;
import graphqlspringbootstarter.graphqlspringbootstarter.pojo.*;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class Update implements GraphQLMutationResolver {
    @Resource
    private  SpeakerService speakerService;

    public Speaker addSpeaker(SpeakerInput speakerInput) {
        Speaker speaker=new Speaker();
        speaker.setName(speakerInput.getName());
        speaker.setTwitter(speakerInput.getTwitter());
        return speakerService.save(speaker);
    }
}
