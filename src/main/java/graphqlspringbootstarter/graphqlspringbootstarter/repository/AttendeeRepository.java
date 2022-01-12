package graphqlspringbootstarter.graphqlspringbootstarter.repository;


import org.springframework.data.repository.CrudRepository;
import graphqlspringbootstarter.graphqlspringbootstarter.pojo.Attendee;
import org.springframework.stereotype.Repository;

@Repository
public interface AttendeeRepository extends CrudRepository<Attendee, Long> {
}
