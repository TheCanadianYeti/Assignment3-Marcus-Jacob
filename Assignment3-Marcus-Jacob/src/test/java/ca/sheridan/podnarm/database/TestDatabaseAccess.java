package ca.sheridan.podnarm.database;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import ca.sheridan.podnarm.beans.Mission;

@SpringBootTest
@AutoConfigureTestDatabase
public class TestDatabaseAccess {
	
	@Autowired
	private DatabaseAccess da;
	
	
	
	
	
	//--TBI!--//
	@Test
	public void testUpdateMission() {
		Mission m1 = new Mission(1, "Johnny Cash", "sfa", "Afad", "Johnny Cash");
		
		String oldValues= m1.toString();
		System.out.println("Old values: " + oldValues);

		da.updateMission(m1);
		
		String newValues = m1.toString();
		System.out.println("New values: " + newValues);
		
		assertEquals(oldValues, newValues);
		
	}//testUpdateMission
	
	
	

//	//--IMPLEMENTED!--//
//	@Test
//	public void testGetMissionsByAgent() {
//			assertTrue(da.getMissionsByAgent("Johnny English").size() > 0); //True == test pass
//	}//testGetMissionByAgent
//	
//	
//	
//	//--IMPLEMENTED!--//
//	@Test
//	public void testGetMissionById() {
//		List<Mission> mission=da.getMissionsByAgent("Johnny English");
//		int id = mission.get(0).getId();
//		
//		
//		assertEquals(da.getMissionById(id), mission.get(0)); //pass == test pass
//		//checks if getMissionById and mission.get return same results
//	}//testGetMissionById
//	
//	
//	
//	//--IMPLEMENTED!--//
//		@Test
//		public void testInsertMission() {
//		Mission m1 = new Mission(1, "Johnny Cash", "asfd", "asda", "Johnny English");
//		int oldSize = da.getMissionsByAgent("Johnny Cash").size();
//		
//		System.out.println("num of missions BEFORE adding new mission: " + oldSize);
//		
//		da.insertMission(m1);
//		
//		int newSize = da.getMissionsByAgent("Johnny Cash").size();
//		System.out.println("num of missions AFTER adding new mission: " + newSize);
//		
//		assertEquals(oldSize+1, newSize); //pass==test pass ☺
//		}//testInsertMission
//		
//	
//
//	//--IMPLEMENTED!--//
//	@Test
//	public void testDeleteMissionById() {
//				
//		List<Mission> mission=da.getMissionsByAgent("Johnny English");
//		int id = mission.get(0).getId();
//		
//		int oldId = da.getMissionsByAgent("Johnny English").size();
//	
//		System.out.println("Johnny English Missions: "+ oldId); //Should be true
//		da.deleteMissionById(id); 
//		
//		int newId = da.getMissionsByAgent("Johnny English").size();
//		
//		System.out.println("Johnny Englihsh Missions after deletion: " + newId);//Should be false
//		assertEquals(oldId, newId+1); // pass == test pass
//		
//	}//testDeleteMissionById
//	
}//#TEST TestDatabaseAccess
