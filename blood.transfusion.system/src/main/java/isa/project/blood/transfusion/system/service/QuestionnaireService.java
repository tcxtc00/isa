package isa.project.blood.transfusion.system.service;

import isa.project.blood.transfusion.system.dto.QuestionnaireDTO;
import isa.project.blood.transfusion.system.model.Questionnaire;

public interface QuestionnaireService {
	
	public Questionnaire createQuestionnaire(QuestionnaireDTO questionnaireDTO);

}
