package ca.sheridan.podnarm.controller;

import java.util.List;
import jakarta.servlet.http.HttpSession;
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
    public String index(Model model, HttpSession session) {
        Mission mission = new Mission();
        model.addAttribute("mission", mission);
        model.addAttribute("agents", mission.getAgents());
        return "index";
    }

    @PostMapping("/selectAgent")
    public String selectAgent(@RequestParam("agent") String agent, HttpSession session) {
        session.setAttribute("currentAgent", agent);
        return "redirect:/viewMissions";
    }

    @GetMapping("/viewMissions")
    public String viewMissions(HttpSession session, Model model) {
        String agent = (String) session.getAttribute("currentAgent");
        if (agent == null) {
            return "redirect:/";
        }
        List<Mission> missions = da.getMissionsByAgent(agent);
        model.addAttribute("agent", agent);
        model.addAttribute("missions", missions);
        return "view_missions";
    }

    @GetMapping("/createMission")
    public String createMissionPage(Model model, HttpSession session) {
        Mission mission = new Mission();
        String currentAgent = (String) session.getAttribute("currentAgent");
        if (currentAgent != null) {
            mission.setAgent(currentAgent);
        }
        model.addAttribute("mission", mission);
        model.addAttribute("agents", mission.getAgents());
        return "create_mission";
    }

    @PostMapping("/createMission")
    public String handleCreateMission(@ModelAttribute Mission mission, HttpSession session) {
        da.insertMission(mission);
        session.setAttribute("currentAgent", mission.getAgent());
        return "redirect:/viewMissions";
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
        return "redirect:/viewMissions";
    }

    @GetMapping("/deleteMission/{id}")
    public String deleteMission(@PathVariable("id") int id) {
        da.deleteMissionById(id);
        return "redirect:/viewMissions";
    }
}