package ca.sheridan.podnarm.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Mission {
	private int id;
	private String agent;
	private String title;
	private String gadget1;
	private String gadget2;	
	private final String[] agents = {"Johnny English", "Natasha Romanova", "Austin Powers"};
}