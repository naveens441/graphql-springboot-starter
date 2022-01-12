package graphqlspringbootstarter.graphqlspringbootstarter.service;

import graphqlspringbootstarter.graphqlspringbootstarter.pojo.*;
import graphqlspringbootstarter.graphqlspringbootstarter.repository.AttendeeTalkRepository;
import graphqlspringbootstarter.graphqlspringbootstarter.repository.TalkRepository;
import graphqlspringbootstarter.graphqlspringbootstarter.repository.AttendeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AttendeeService {

    @Autowired
    private AttendeeRepository attendeeRepository;

    @Autowired
    private AttendeeTalkRepository attendeeTalkRepository;

    public List<Attendee> findAll() {
        return (List<Attendee>) attendeeRepository.findAll();
    }

    public List<Attendee> findAllAttendiesForTalk(Talk talk) {
        List<AttendeeTalk> at = attendeeTalkRepository.findAllByTalkId(talk.getId());

        return at.stream()
                .map(e -> attendeeRepository.findById(e.getAttendeeId()))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());
    }
}
