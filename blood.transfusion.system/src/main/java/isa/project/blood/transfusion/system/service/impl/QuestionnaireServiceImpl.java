package isa.project.blood.transfusion.system.service.impl;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import isa.project.blood.transfusion.system.dto.QuestionnaireDTO;
import isa.project.blood.transfusion.system.model.Gender;
import isa.project.blood.transfusion.system.model.Questionnaire;
import isa.project.blood.transfusion.system.model.User;
import isa.project.blood.transfusion.system.repository.QuestionnaireRepository;
import isa.project.blood.transfusion.system.repository.UserRepository;
import isa.project.blood.transfusion.system.service.QuestionnaireService;

@Service
public class QuestionnaireServiceImpl implements QuestionnaireService{
	
	@Autowired
	private QuestionnaireRepository questionnaireRepository;
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public Questionnaire createQuestionnaire(QuestionnaireDTO questionnaireDTO) {
		
		if(questionnaireDTO.getUsername().equals("")) {
			return null;
		}
		
		User user = userRepository.findByUsername(questionnaireDTO.getUsername());
		
		if(questionnaireDTO.getIsAbleToDonate() == null) {
			return null;
		}
		if(questionnaireDTO.getBloodTransfusionInLast6Months() == null) {
			return null;
		}
		if(questionnaireDTO.getCuredOfSomeDiseases() == null) {
			return null;
		}
		if(questionnaireDTO.getDecreasedPlatelets() == null) {
			return null;
		}
		if(questionnaireDTO.getIsDonor() == null) {
			return null;
		}
		if(questionnaireDTO.getDrinkAlcohol() == null) {
			return null;
		}
		if(questionnaireDTO.getFoodConsume() == null) {
			return null;
		}
		if(questionnaireDTO.getHasFeverOrFlu() == null) {
			return null;
		}
		if(user.getGender().equals(Gender.Femaile) && questionnaireDTO.getHasPeriod() == null) {	
			return null;
		}
		if(questionnaireDTO.getHasProblemWithGlands() == null) {
			return null;
		}
		if(questionnaireDTO.getHasSkinDiseases() == null) {
			return null;
		}
		if(questionnaireDTO.getHasSurgeryInLast6Month() == null) {
			return null;
		}
		if(questionnaireDTO.getLessThan50Kilograms() == null) {
			return null;
		}
		if(questionnaireDTO.getLowBloodPressure() == null) {
			return null;
		}
		if(user.getGender().equals(Gender.Femaile) && questionnaireDTO.getIsPregnant() == null) {	
			return null;
		}
		if(questionnaireDTO.getSuffersFromChronicDiseases() == null) {
			return null;
		}
		if(questionnaireDTO.getTakeMedicineRegulary() == null) {
			return null;
		}
		if(questionnaireDTO.getTakeMedicineThreeDaysAgo() == null) {
			return null;
		}
		if(questionnaireDTO.getTickBite12MonthsAgo() == null) {
			return null;
		}
		if(questionnaireDTO.getToothExtractionSevenDaysAgo() == null) {
			return null;
		}
		if(questionnaireDTO.getUsedAspirin() == null) {
			return null;
		}
		
		Questionnaire questionnaire = new Questionnaire();
		questionnaire.setAbleToDonate(questionnaireDTO.getIsAbleToDonate());
		questionnaire.setBloodTransfusionInLast6Months(questionnaireDTO.getBloodTransfusionInLast6Months());
		questionnaire.setCuredOfSomeDiseases(questionnaireDTO.getCuredOfSomeDiseases());
		questionnaire.setDecreasedPlatelets(questionnaireDTO.getDecreasedPlatelets());
		questionnaire.setDonor(questionnaireDTO.getIsDonor());
		questionnaire.setDrinkAlcohol(questionnaireDTO.getDrinkAlcohol());
		questionnaire.setFoodConsume(questionnaireDTO.getFoodConsume());
		questionnaire.setHasFeverOrFlu(questionnaireDTO.getHasFeverOrFlu());
		if(user.getGender().equals(Gender.Femaile)) {	
			questionnaire.setHasPeriod(questionnaireDTO.getHasPeriod());
		}
		questionnaire.setHasProblemWithGlands(questionnaireDTO.getHasProblemWithGlands());
		questionnaire.setHasSkinDiseases(questionnaireDTO.getHasSkinDiseases());
		questionnaire.setHasSurgeryInLast6Month(questionnaireDTO.getHasSurgeryInLast6Month());
		questionnaire.setLessThan50Kilograms(questionnaireDTO.getLessThan50Kilograms());
		questionnaire.setLowBloodPressure(questionnaireDTO.getLowBloodPressure());
		questionnaire.setPiercingOrTattooInLast6Month(questionnaireDTO.getPiercingOrTattooInLast6Month());
		if(user.getGender().equals(Gender.Femaile)) {	
			questionnaire.setPregnant(questionnaireDTO.getIsPregnant());		}
		questionnaire.setSuffersFromChronicDiseases(questionnaireDTO.getSuffersFromChronicDiseases());
		questionnaire.setTakeMedicineRegulary(questionnaireDTO.getTakeMedicineRegulary());
		questionnaire.setTakeMedicineThreeDaysAgo(questionnaireDTO.getTakeMedicineThreeDaysAgo());
		questionnaire.setTickBite12MonthsAgo(questionnaireDTO.getTickBite12MonthsAgo());
		questionnaire.setToothExtractionSevenDaysAgo(questionnaireDTO.getToothExtractionSevenDaysAgo());
		questionnaire.setUsedAspirin(questionnaireDTO.getUsedAspirin());
		questionnaire.setUser(user);
		questionnaire.setDate(LocalDateTime.now());
		return questionnaireRepository.save(questionnaire);
	}

}
