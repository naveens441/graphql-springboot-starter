package graphqlspringbootstarter.graphqlspringbootstarter.repository;

import graphqlspringbootstarter.graphqlspringbootstarter.pojo.Speaker;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpeakerRepository extends CrudRepository<Speaker,Long> {
}
