package ca.sheridan.podnarm.database;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import ca.sheridan.podnarm.beans.Mission;

@Repository
public class DatabaseAccess {

	@Autowired
	protected NamedParameterJdbcTemplate jdbc;

	public List<Mission> getMissionsByAgent(String agent) {
		MapSqlParameterSource params = new MapSqlParameterSource();
		String query = "SELECT * FROM mission WHERE agent = :agent";
		params.addValue("agent", agent);
		return jdbc.query(query, params, new BeanPropertyRowMapper<>(Mission.class));
	}

	public Mission getMissionById(int id) {
		MapSqlParameterSource params = new MapSqlParameterSource();
		String query = "SELECT * FROM mission WHERE id = :id";
		params.addValue("id", id);
		List<Mission> missions = jdbc.query(query, params, new BeanPropertyRowMapper<>(Mission.class));
		if (!missions.isEmpty()) {
			return missions.get(0);
		}
		return null;
	}

	public int insertMission(Mission mission) {
		MapSqlParameterSource params = new MapSqlParameterSource();
		String query = "INSERT INTO mission (agent, title, gadget1, gadget2) VALUES (:agent, :title, :gadget1, :gadget2)";
		params.addValue("agent", mission.getAgent());
		params.addValue("title", mission.getTitle());
		params.addValue("gadget1", mission.getGadget1());
		params.addValue("gadget2", mission.getGadget2());
		return jdbc.update(query, params);
	}

	public int updateMission(Mission mission) {
		MapSqlParameterSource params = new MapSqlParameterSource();
		String query = "UPDATE mission SET title = :title, gadget1 = :gadget1, gadget2 = :gadget2 WHERE id = :id";
		params.addValue("id", mission.getId());
		params.addValue("title", mission.getTitle());
		params.addValue("gadget1", mission.getGadget1());
		params.addValue("gadget2", mission.getGadget2());
		return jdbc.update(query, params);
	}

	public int deleteMissionById(int id) {
		MapSqlParameterSource params = new MapSqlParameterSource();
		String query = "DELETE FROM mission WHERE id = :id";
		params.addValue("id", id);
		return jdbc.update(query, params);
	}
}