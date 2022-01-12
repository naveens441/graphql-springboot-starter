package graphqlspringbootstarter.graphqlspringbootstarter.repository;

import graphqlspringbootstarter.graphqlspringbootstarter.pojo.SpeakerTalk;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpeakerTalkRepository extends CrudRepository<SpeakerTalk,Long> {
    List<SpeakerTalk> findAllBySpeakerId(Long speakerId);
    List<SpeakerTalk> findAllByTalkId(Long talkId);
}
