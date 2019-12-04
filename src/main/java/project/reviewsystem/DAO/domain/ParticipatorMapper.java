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
			+ "participator(email, firstname, minit, lastname, phone, affiliation, password) "
		+ "VALUES "
			+ "(#{email}, #{firstname}, #{minit}, #{lastname}, #{phone}, #{affiliation}, #{password})"
	)
	public void registerParticipator(Participator participator);

	@Insert("INSERT INTO author(email) VALUES (#{email})")
	public void registerAuthor(Participator participator);

	@Insert("INSERT INTO reviewer(email) VALUES (#{email})")
	public void registerReviewer(Participator participator);


	@Select(
		"SELECT "
    		+ "p.email, p.firstname, p.minit, p.lastname, p.phone, p.affiliation, "
    		+ "( "
        		+ "CASE "
            		+ "WHEN a.email IS NOT NULL AND r.email IS NOT NULL THEN 'Both' "
            		+ "WHEN a.email IS NOT NULL THEN 'Author' "
            		+ "WHEN r.email IS NOT NULL THEN 'Reviewer' "
            		+ "ELSE null "
        		+ "END "
    		+ ") as role "
		+ "FROM Participator p "
		+ "LEFT JOIN author a ON p.email = a.email "
		+ "LEFT JOIN reviewer r ON p.email = r.email "
		+ "WHERE p.email = #{email} AND p.password = #{password}"
	)
	public List<Participator> getParticipatorListFromData(Participator participator);
}
