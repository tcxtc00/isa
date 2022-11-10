package isa.project.blood.transfusion.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import isa.project.blood.transfusion.system.dto.QuestionnaireDTO;
import isa.project.blood.transfusion.system.model.Questionnaire;
import isa.project.blood.transfusion.system.service.QuestionnaireService;

@RestController
@RequestMapping(value = "api/questionnaires")
public class QuestionnaireController {
	
	@Autowired
	private QuestionnaireService questionnaireService;
	
	
	@PreAuthorize("hasRole('REGISTEREDUSER')")
	@PostMapping(path = "/create")
	public ResponseEntity<?> create(@RequestBody QuestionnaireDTO questionnaireDTO){
		Questionnaire questionnaire = questionnaireService.createQuestionnaire(questionnaireDTO);
		if(questionnaire == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(questionnaire, HttpStatus.CREATED);
	}

}
