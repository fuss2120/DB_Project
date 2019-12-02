package project.reviewsystem.DAO.domain;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Insert;

import project.reviewsystem.domain.Participator;

@Mapper
public interface ParticipatorMapper {

	@Insert(
		"INSERT INTO "
			+ "participator(email, firstname, minit, lastname, phone, affiliation) "
		+ "VALUES "
			+ "(#{email}, #{firstname}, #{minit}, #{lastname}, #{phone}, #{affiliation})"
	)
	public void registerParticipator(Participator participator);

	@Insert("INSERT INTO author(email) VALUES (#{email})")
	public void registerAuthor(Participator participator);

	@Insert("INSERT INTO reviewer(email) VALUES (#{email})")
	public void registerReviewer(Participator participator);

	@Select(
		"SELECT email, firstname, minit, lastname, phone, affiliation "
		+ "FROM participator "
		+ "WHERE email = #{email}"
	)
	public List<Participator> getParticipatorListFromData(Participator participator);
}
