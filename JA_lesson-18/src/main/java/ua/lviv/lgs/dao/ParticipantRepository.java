package ua.lviv.lgs.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import ua.lviv.lgs.domain.Level;
import ua.lviv.lgs.domain.Participant;

@Repository
public class ParticipantRepository {

	private List<Participant> participants = new ArrayList<>();

	@PostConstruct
	public void init() {

		Participant participant1 = new Participant();
		participant1.setId(1);
		participant1.setName("David");
		participant1.setEmail("david@mail.com");
		participant1.setLevel(Level.L1);
		participant1.setPrimarySkill("Skill 1");

		Participant participant2 = new Participant();
		participant2.setId(2);
		participant2.setName("Mike");
		participant2.setEmail("mike@mail.com");
		participant2.setLevel(Level.L2);
		participant2.setPrimarySkill("Skill 2");

		Participant participant3 = new Participant();
		participant3.setId(3);
		participant3.setName("Eric");
		participant3.setEmail("eric@mail.com");
		participant3.setLevel(Level.L3);
		participant3.setPrimarySkill("Skill 3");

		Participant participant4 = new Participant();
		participant4.setId(4);
		participant4.setName("Harry");
		participant4.setEmail("harry@mail.com");
		participant4.setLevel(Level.L4);
		participant4.setPrimarySkill("Skill 4");

		Participant participant5 = new Participant();
		participant5.setId(5);
		participant5.setName("Erica");
		participant5.setEmail("erica@mail.com");
		participant5.setLevel(Level.L5);
		participant5.setPrimarySkill("Skill 5");

		participants.add(participant1);
		participants.add(participant2);
		participants.add(participant3);
		participants.add(participant4);
		participants.add(participant5);
	}

	public List<Participant> findAllParticipants() {
		return participants;
	}

	public Participant findOne(int id) {
		return participants.stream().filter(participant -> participant.getId() == id).findFirst().orElse(null);
	}			

	public void save(Participant participant) {
		Participant participantToUpdate = null;
		// update
		if (participant.getId() != null) {
			participantToUpdate = findOne(participant.getId());
			int partisipantIndex = participants.indexOf(participantToUpdate);
			participantToUpdate.setName(participant.getName());
			participantToUpdate.setEmail(participant.getEmail());
			participantToUpdate.setLevel(participant.getLevel());
			participantToUpdate.setPrimarySkill(participant.getPrimarySkill());
			participants.set(partisipantIndex, participantToUpdate);
		} else {
		// save
			participant.setId(participants.get(participants.size() - 1).getId() + 1);
			participants.add(participant);
		}
	}

	public void delete(int id) {
		Iterator<Participant> iter = participants.iterator();
		while (iter.hasNext()) {
			if (iter.next().getId() == id) {
				iter.remove();
			}
		}
	}

}
