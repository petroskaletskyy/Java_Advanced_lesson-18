package ua.lviv.lgs.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ua.lviv.lgs.domain.Participant;
import ua.lviv.lgs.service.ParticipantService;

@Controller
public class ParticipantController {
	
	@Autowired
	ParticipantService participantService;

	@GetMapping("/")
	public String init(HttpServletRequest request) {
		request.setAttribute("partisipants", participantService.findAllParticipants());
		request.setAttribute("mode", "PARTISIPANT_VIEW");
		return "index";
	} 
	
	@GetMapping("/new")
	public String newPartisipant(HttpServletRequest request) {
		request.setAttribute("mode", "PARTISIPANT_CREATE");
		return "index";
	}
	
	@PostMapping("/save")
	public String save(@ModelAttribute Participant participant, HttpServletRequest request) {
		participantService.save(participant);
		request.setAttribute("partisipants", participantService.findAllParticipants());
		request.setAttribute("mode", "PARTISIPANT_VIEW");
		return "index";
	}
	
	@GetMapping("/update")
	public String update(@RequestParam Integer id, HttpServletRequest request) {
		request.setAttribute("partisipant", participantService.findOne(id));
		request.setAttribute("mode", "PARTISIPANT_EDIT");
		return "index";
	}
	
	@GetMapping("/delete")
	public String deleteParticipant(@RequestParam Integer id, HttpServletRequest request) {
		participantService.delete(id);
		request.setAttribute("partisipants", participantService.findAllParticipants());
		request.setAttribute("mode", "PARTISIPANT_VIEW");
		return "index";
	}
}
