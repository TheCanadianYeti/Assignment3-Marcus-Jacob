package ca.sheridan.podnarm.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ca.sheridan.podnarm.beans.Mission;
import ca.sheridan.podnarm.database.DatabaseAccess;

@Controller
public class HomeController {

    @Autowired
    private DatabaseAccess da;

    @GetMapping("/")
    public String index(Model model) {
        Mission mission = new Mission();
        model.addAttribute("mission", mission);
        model.addAttribute("agents", mission.getAgents());
        return "index";
    }

    @PostMapping("/viewMissions")
    public String viewMissionsPost(@RequestParam("agent") String agent) {
        return "redirect:/viewMissions/" + agent;
    }

    @GetMapping("/viewMissions/{agent}")
    public String viewMissionsByAgent(@PathVariable("agent") String agent, Model model) {
        List<Mission> missions = da.getMissionsByAgent(agent);
        model.addAttribute("agent", agent);
        model.addAttribute("missions", missions);
        return "view_missions";
    }

    @GetMapping("/createMission")
    public String createMissionPage(Model model) {
        Mission mission = new Mission();
        model.addAttribute("mission", mission);
        model.addAttribute("agents", mission.getAgents());
        return "create_mission";
    }

    @PostMapping("/createMission")
    public String handleCreateMission(@ModelAttribute Mission mission) {
        da.insertMission(mission);
        return "redirect:/viewMissions/" + mission.getAgent();
    }

    @GetMapping("/editMission/{id}")
    public String editMissionPage(@PathVariable("id") int id, Model model) {
        Mission mission = da.getMissionById(id);
        model.addAttribute("mission", mission);
        return "edit_missions";
    }

    @PostMapping("/updateMission")
    public String handleUpdateMission(@ModelAttribute Mission mission) {
        da.updateMission(mission);
        return "redirect:/viewMissions/" + mission.getAgent();
    }

    @GetMapping("/deleteMission/{id}")
    public String deleteMission(@PathVariable("id") int id) {
        Mission mission = da.getMissionById(id);
        String agent = (mission != null) ? mission.getAgent() : "";
        da.deleteMissionById(id);
        return "redirect:/viewMissions/" + agent;
    }
}