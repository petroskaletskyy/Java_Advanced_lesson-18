package ua.lviv.lgs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.lviv.lgs.dao.ParticipantRepository;
import ua.lviv.lgs.domain.Participant;

@Service
public class ParticipantService {

	@Autowired
	ParticipantRepository participantRepository;

	public List<Participant> findAllParticipants() {
		return participantRepository.findAllParticipants();
	}

	public Participant findOne(Integer id) {
		return participantRepository.findOne(id);
	}

	public void save(Participant participant) {
		participantRepository.save(participant);
	}

	public void delete(Integer id) {
		participantRepository.delete(id);
	}

}
