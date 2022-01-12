package graphqlspringbootstarter.graphqlspringbootstarter.repository;

import org.springframework.data.repository.CrudRepository;
import graphqlspringbootstarter.graphqlspringbootstarter.pojo.AttendeeTalk;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AttendeeTalkRepository extends CrudRepository<AttendeeTalk, Long> {
    List<AttendeeTalk> findAllByAttendeeId(Long attendeeId);

    List<AttendeeTalk> findAllByTalkId(Long talkId);
}
