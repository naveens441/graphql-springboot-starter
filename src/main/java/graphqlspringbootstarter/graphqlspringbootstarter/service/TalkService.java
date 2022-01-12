package graphqlspringbootstarter.graphqlspringbootstarter.service;

import graphqlspringbootstarter.graphqlspringbootstarter.pojo.*;
import graphqlspringbootstarter.graphqlspringbootstarter.repository.AttendeeTalkRepository;
import graphqlspringbootstarter.graphqlspringbootstarter.repository.SpeakerTalkRepository;
import graphqlspringbootstarter.graphqlspringbootstarter.repository.TalkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TalkService {

    @Autowired
    private TalkRepository talkRepository;

    @Autowired
    private SpeakerTalkRepository speakerTalkRepository;

    @Autowired
    private AttendeeTalkRepository attendeeTalkRepository;

    public List<Talk> findAll() {
        return (List<Talk>) talkRepository.findAll();
    }

    public List<Talk> findAllTalksBySpeaker(Speaker speaker) {
        List<SpeakerTalk> st = speakerTalkRepository.findAllBySpeakerId(speaker.getId());

        return st.stream()
                .map(e -> talkRepository.findById(e.getTalkId()))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());
    }

    public List<Talk> findAllTAlksByAttendee(Attendee attendee) {
        List<AttendeeTalk> st = attendeeTalkRepository.findAllByAttendeeId(attendee.getId());

        return st.stream()
                .map(e -> talkRepository.findById(e.getTalkId()))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());

    }
}
