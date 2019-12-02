package project.reviewsystem.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import project.reviewsystem.DAO.ParticipatorDAO;
import project.reviewsystem.domain.Participator;

@Component
public class ParticipatorService {
	
	@Autowired
	ParticipatorDAO participatorDAO;

	public void registerParticipator(Participator participator) {
		participatorDAO.registerParticipator(participator);
		registerParticipatorAsRole(participator);
	}

	private void registerParticipatorAsRole(Participator participator) {
		if (participator.getRole().equals("Author"))
			participatorDAO.registerAuthor(participator);
		else if (participator.getRole().equals("Reviewer"))
			participatorDAO.registerReviewer(participator);
		else if (participator.getRole().equals("Both")) {
			participatorDAO.registerAuthor(participator);
			participatorDAO.registerReviewer(participator);
		}
	}

	public Participator getParticipatorFromData(Participator participator) {
		List<Participator> participatorList = new ArrayList<Participator>();
		participatorList = participatorDAO.getParticipatorListFromData(participator);
		if (participatorList.size() != 1)
			return null;
		return participatorList.get(0);
	}
	
}
