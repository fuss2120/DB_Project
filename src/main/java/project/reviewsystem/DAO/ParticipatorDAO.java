package project.reviewsystem.DAO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import project.reviewsystem.DAO.domain.ParticipatorMapper;
import project.reviewsystem.domain.Participator;

@Component
public class ParticipatorDAO {
	
	@Autowired
	ParticipatorMapper participatorMapper;

	public void registerParticipator(Participator participator) {
		participatorMapper.registerParticipator(participator);
	}

	public void registerAuthor(Participator participator) {
		System.out.println("Registering author");
		participatorMapper.registerAuthor(participator);
	}

	public void registerReviewer(Participator participator) {
		System.out.println("Registering reviewer");
		participatorMapper.registerReviewer(participator);
	}
	
}
