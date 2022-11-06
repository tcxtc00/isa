package isa.project.blood.transfusion.system.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Questionnaire {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	@Column(name = "is__donor", nullable = false)
	private boolean isDonor;
	
	@Column(name = "is_able_to_donate", nullable = false)
	private boolean isAbleToDonate;
	
	@Column(name = "food_consume", nullable = false)
	private boolean foodConsume;
	
	@Column(name = "take_medicine_regulary", nullable = false)
	private boolean takeMedicineRegulary;
	
	@Column(name = "take_medicine_three_days_ago", nullable = false)
	private boolean takeMedicineThreeDaysAgo;
	
	@Column(name = "used_aspirin", nullable = false)
	private boolean usedAspirin;
	
	@Column(name = "tooth_extraction_seven_days_ago", nullable = false)
	private boolean toothExtractionSevenDaysAgo;
	
	@Column(name = "has_fever_or_flu", nullable = false)
	private boolean hasFeverOrFlu;
	
	@Column(name = "tick_bite_12_months_ago", nullable = false)
	private boolean tickBite12MonthsAgo;
	
	@Column(name = "cured_of_some_diseases", nullable = false)
	private boolean curedOfSomeDiseases;
	
	@Column(name = "suffers_from_chronic_diseases", nullable = false)
	private boolean suffersFromChronicDiseases;
	
	@Column(name = "has_problem_with_glands", nullable = false)
	private boolean hasProblemWithGlands;
	
	@Column(name = "has_skin_diseases", nullable = false)
	private boolean hasSkinDiseases;
	
	@Column(name = "decreased_platelets", nullable = false)
	private boolean decreasedPlatelets;
	
	@Column(name = "has_surgery_in_last_6_months", nullable = false)
	private boolean hasSurgeryInLast6Month;
	
	@Column(name = "piercing_or_tattoo_in_last_6_months", nullable = false)
	private boolean piercingOrTattooInLast6Month;
	
	@Column(name = "drink_alcohol", nullable = false)
	private boolean drinkAlcohol;
	
	@Column(name = "low_blood_pressure", nullable = false)
	private boolean lowBloodPressure;
	
	@Column(name = "blood_transfusion_in_last_6_months", nullable = false)
	private boolean bloodTransfusionInLast6Months;
	
	@Column(name = "less_than_50_kilograms", nullable = false)
	private boolean lessThan50Kilograms;
	
	@Column(name = "is_pregnant")
	private boolean isPregnant;
	
	@Column(name = "has_period")
	private boolean hasPeriod;
	
	@Column(name = "date")
	private LocalDateTime date;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public boolean isDonor() {
		return isDonor;
	}

	public void setDonor(boolean isDonor) {
		this.isDonor = isDonor;
	}

	public boolean isAbleToDonate() {
		return isAbleToDonate;
	}

	public void setAbleToDonate(boolean isAbleToDonate) {
		this.isAbleToDonate = isAbleToDonate;
	}

	public boolean isFoodConsume() {
		return foodConsume;
	}

	public void setFoodConsume(boolean foodConsume) {
		this.foodConsume = foodConsume;
	}

	public boolean isTakeMedicineRegulary() {
		return takeMedicineRegulary;
	}

	public void setTakeMedicineRegulary(boolean takeMedicineRegulary) {
		this.takeMedicineRegulary = takeMedicineRegulary;
	}

	public boolean isTakeMedicineThreeDaysAgo() {
		return takeMedicineThreeDaysAgo;
	}

	public void setTakeMedicineThreeDaysAgo(boolean takeMedicineThreeDaysAgo) {
		this.takeMedicineThreeDaysAgo = takeMedicineThreeDaysAgo;
	}

	public boolean isUsedAspirin() {
		return usedAspirin;
	}

	public void setUsedAspirin(boolean usedAspirin) {
		this.usedAspirin = usedAspirin;
	}

	public boolean isToothExtractionSevenDaysAgo() {
		return toothExtractionSevenDaysAgo;
	}

	public void setToothExtractionSevenDaysAgo(boolean toothExtractionSevenDaysAgo) {
		this.toothExtractionSevenDaysAgo = toothExtractionSevenDaysAgo;
	}

	public boolean isHasFeverOrFlu() {
		return hasFeverOrFlu;
	}

	public void setHasFeverOrFlu(boolean hasFeverOrFlu) {
		this.hasFeverOrFlu = hasFeverOrFlu;
	}

	public boolean isTickBite12MonthsAgo() {
		return tickBite12MonthsAgo;
	}

	public void setTickBite12MonthsAgo(boolean tickBite12MonthsAgo) {
		this.tickBite12MonthsAgo = tickBite12MonthsAgo;
	}

	public boolean isCuredOfSomeDiseases() {
		return curedOfSomeDiseases;
	}

	public void setCuredOfSomeDiseases(boolean curedOfSomeDiseases) {
		this.curedOfSomeDiseases = curedOfSomeDiseases;
	}

	public boolean isSuffersFromChronicDiseases() {
		return suffersFromChronicDiseases;
	}

	public void setSuffersFromChronicDiseases(boolean suffersFromChronicDiseases) {
		this.suffersFromChronicDiseases = suffersFromChronicDiseases;
	}

	public boolean isHasProblemWithGlands() {
		return hasProblemWithGlands;
	}

	public void setHasProblemWithGlands(boolean hasProblemWithGlands) {
		this.hasProblemWithGlands = hasProblemWithGlands;
	}

	public boolean isHasSkinDiseases() {
		return hasSkinDiseases;
	}

	public void setHasSkinDiseases(boolean hasSkinDiseases) {
		this.hasSkinDiseases = hasSkinDiseases;
	}

	public boolean isDecreasedPlatelets() {
		return decreasedPlatelets;
	}

	public void setDecreasedPlatelets(boolean decreasedPlatelets) {
		this.decreasedPlatelets = decreasedPlatelets;
	}

	public boolean isHasSurgeryInLast6Month() {
		return hasSurgeryInLast6Month;
	}

	public void setHasSurgeryInLast6Month(boolean hasSurgeryInLast6Month) {
		this.hasSurgeryInLast6Month = hasSurgeryInLast6Month;
	}

	public boolean isPiercingOrTattooInLast6Month() {
		return piercingOrTattooInLast6Month;
	}

	public void setPiercingOrTattooInLast6Month(boolean piercingOrTattooInLast6Month) {
		this.piercingOrTattooInLast6Month = piercingOrTattooInLast6Month;
	}

	public boolean isDrinkAlcohol() {
		return drinkAlcohol;
	}

	public void setDrinkAlcohol(boolean drinkAlcohol) {
		this.drinkAlcohol = drinkAlcohol;
	}

	public boolean isLowBloodPressure() {
		return lowBloodPressure;
	}

	public void setLowBloodPressure(boolean lowBloodPressure) {
		this.lowBloodPressure = lowBloodPressure;
	}

	public boolean isBloodTransfusionInLast6Months() {
		return bloodTransfusionInLast6Months;
	}

	public void setBloodTransfusionInLast6Months(boolean bloodTransfusionInLast6Months) {
		this.bloodTransfusionInLast6Months = bloodTransfusionInLast6Months;
	}

	public boolean isLessThan50Kilograms() {
		return lessThan50Kilograms;
	}

	public void setLessThan50Kilograms(boolean lessThan50Kilograms) {
		this.lessThan50Kilograms = lessThan50Kilograms;
	}

	public boolean isPregnant() {
		return isPregnant;
	}

	public void setPregnant(boolean isPregnant) {
		this.isPregnant = isPregnant;
	}

	public boolean isHasPeriod() {
		return hasPeriod;
	}

	public void setHasPeriod(boolean hasPeriod) {
		this.hasPeriod = hasPeriod;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	
	
	
}
