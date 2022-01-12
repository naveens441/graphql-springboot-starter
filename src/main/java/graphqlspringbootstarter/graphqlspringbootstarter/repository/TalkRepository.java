package graphqlspringbootstarter.graphqlspringbootstarter.repository;
import graphqlspringbootstarter.graphqlspringbootstarter.pojo.Talk;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TalkRepository extends CrudRepository<Talk, Long> {
}
