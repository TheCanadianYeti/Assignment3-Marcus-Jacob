package ca.sheridan.podnarm.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

import ca.sheridan.podnarm.database.DatabaseAccess;

@SpringBootTest
@AutoConfigureTestDatabase
@AutoConfigureMockMvc
public class TestHomeController {

	@Autowired
	private DatabaseAccess da;
	
	@Autowired
	private MockMvc mockmvc;
	
	@Test
	public void testIndex() throws Exception{
		mockmvc.perform(get("/")).andExpect(status().isOk()).andExpect(view().name("index")).andDo(print());
	}//testIndex
	
	@Test
	public void testSelectAgent() throws Exception{
		
	}//TestSelectAgent
	
	@Test
	public void testViewMissions() throws Exception{
		
	}//testViewMissions
	
	@Test
	public void testCreateMissionPage() throws Exception{
		
	}//testCreateMissionPage
	
	@Test
	public void testEditMissionPage() throws Exception{
		
	}//testEditMissionPage
	
	@Test
	public void testHandleUpdateMission() throws Exception{
		
	}//testHandleUpdateMission
	
	@Test
	public void testDeleteMission() throws Exception{
		
	}//testDeleteMission
}//TestHomeController
