import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { QuestionnaireService } from '../services/questionnaire.service';
import { UserService } from '../services/user.service';

@Component({
  selector: 'app-questionnaire',
  templateUrl: './questionnaire.component.html',
  styleUrls: ['./questionnaire.component.css']
})
export class QuestionnaireComponent implements OnInit {

  isDonor: boolean
  isAbleToDonate: boolean
  foodConsume: boolean
  takeMedicineRegulary: boolean
  takeMedicineThreeDaysAgo: boolean
  usedAspirin: boolean
  toothExtractionSevenDaysAgo: boolean
  hasFeverOrFlu: boolean
  tickBite12MonthsAgo: boolean
  curedOfSomeDiseases: boolean
  suffersFromChronicDiseases: boolean
  hasProblemWithGlands: boolean
  hasSkinDiseases: boolean
  decreasedPlatelets: boolean
  hasSurgeryInLast6Month: boolean
  piercingOrTattooInLast6Month: boolean
  drinkAlcohol: boolean
  lowBloodPressure: boolean
  bloodTransfusionInLast6Months: boolean
  lessThan50Kilograms: boolean
  isPregnant: boolean
  hasPeriod: boolean

  isDonorCheck = false
  isAbleToDonateCheck = false
  foodConsumeCheck = false
  takeMedicineRegularyCheck = false
  takeMedicineThreeDaysAgoCheck = false
  usedAspirinCheck = false
  toothExtractionSevenDaysAgoCheck = false
  hasFeverOrFluCheck = false
  tickBite12MonthsAgoCheck = false
  curedOfSomeDiseasesCheck = false
  suffersFromChronicDiseasesCheck = false
  hasProblemWithGlandsCheck = false
  hasSkinDiseasesCheck = false
  decreasedPlateletsCheck = false
  hasSurgeryInLast6MonthCheck = false
  piercingOrTattooInLast6MonthCheck = false
  drinkAlcoholCheck = false
  lowBloodPressureCheck = false
  bloodTransfusionInLast6MonthsCheck = false
  lessThan50KilogramsCheck = false
  isPregnantCheck = false
  hasPeriodCheck = false


  user: any

  constructor(private questionnaireService: QuestionnaireService, private userService: UserService, private router: Router) { }

  ngOnInit(): void {
    this.userService.current().subscribe((response: any) => {
      this.user = response
      console.log(this.user)
    })
  }

  checkIsDonor() {
    if (this.isDonor == null) {
      this.isDonorCheck = true;
    } else {
      this.isDonorCheck = false;
    }
  }

  checkIsAbleToDonate() {
    if (this.isAbleToDonate == null) {
      this.isAbleToDonateCheck = true;
    } else {
      this.isAbleToDonateCheck = false;
    }
  }

  checkFoodConsume() {
    if (this.foodConsume == null) {
      this.foodConsumeCheck = true;
    } else {
      this.foodConsumeCheck = false;
    }
  }

  checkTakeMedicineRegulary() {
    if (this.takeMedicineRegulary == null) {
      this.takeMedicineRegularyCheck = true;
    } else {
      this.takeMedicineRegularyCheck = false;
    }
  }

  checkTakeMedicineThreeDaysAgo() {
    if (this.takeMedicineThreeDaysAgo == null) {
      this.takeMedicineThreeDaysAgoCheck = true;
    } else {
      this.takeMedicineThreeDaysAgoCheck = false;
    }
  }

  checkUsedAspirin() {
    if (this.usedAspirin == null) {
      this.usedAspirinCheck = true;
    } else {
      this.usedAspirinCheck = false;
    }
  }

  checkToothExtractionSevenDaysAgo() {
    if (this.toothExtractionSevenDaysAgo == null) {
      this.toothExtractionSevenDaysAgoCheck = true;
    } else {
      this.toothExtractionSevenDaysAgoCheck = false;
    }
  }

  checkHasFeverOrFlu() {
    if (this.hasFeverOrFlu == null) {
      this.hasFeverOrFluCheck = true;
    } else {
      this.hasFeverOrFluCheck = false;
    }
  }

  checkTickBite12MonthsAgo() {
    if (this.tickBite12MonthsAgo == null) {
      this.tickBite12MonthsAgoCheck = true;
    } else {
      this.tickBite12MonthsAgoCheck = false;
    }
  }

  checkCuredOfSomeDiseases() {
    if (this.curedOfSomeDiseases == null) {
      this.curedOfSomeDiseasesCheck = true;
    } else {
      this.curedOfSomeDiseasesCheck = false;
    }
  }

  checkSuffersFromChronicDiseases() {
    if (this.suffersFromChronicDiseases == null) {
      this.suffersFromChronicDiseasesCheck = true;
    } else {
      this.suffersFromChronicDiseasesCheck = false;
    }
  }

  checkHasProblemWithGlands() {
    if (this.hasProblemWithGlands == null) {
      this.hasProblemWithGlandsCheck = true;
    } else {
      this.hasProblemWithGlandsCheck = false;
    }
  }

  checkHasSkinDiseases() {
    if (this.hasSkinDiseases == null) {
      this.hasSkinDiseasesCheck = true;
    } else {
      this.hasSkinDiseasesCheck = false;
    }
  }

  checkDecreasedPlatelets() {
    if (this.decreasedPlatelets == null) {
      this.decreasedPlateletsCheck = true;
    } else {
      this.decreasedPlateletsCheck = false;
    }
  }

  checkHasSurgeryInLast6Month() {
    if (this.hasSurgeryInLast6Month == null) {
      this.hasSurgeryInLast6MonthCheck = true;
    } else {
      this.hasSurgeryInLast6MonthCheck = false;
    }
  }

  checkDrinkAlcohol() {
    if (this.drinkAlcohol == null) {
      this.drinkAlcoholCheck = true;
    } else {
      this.drinkAlcoholCheck = false;
    }
  }

  checkLowBloodPressure() {
    if (this.lowBloodPressure == null) {
      this.lowBloodPressureCheck = true;
    } else {
      this.lowBloodPressureCheck = false;
    }
  }

  checkBloodTransfusionInLast6Months() {
    if (this.bloodTransfusionInLast6Months == null) {
      this.bloodTransfusionInLast6MonthsCheck = true;
    } else {
      this.bloodTransfusionInLast6MonthsCheck = false;
    }
  }

  checkLessThan50Kilograms() {
    if (this.lessThan50Kilograms == null) {
      this.lessThan50KilogramsCheck = true;
    } else {
      this.lessThan50KilogramsCheck = false;
    }
  }

  checkIsPregnant() {
    if (this.isPregnant == null && this.user.gender == 'Female') {
      this.isPregnantCheck = true;
    } else {
      this.isPregnantCheck = false;
    }
  }

  checkHasPeriod() {
    if (this.hasPeriod == null && this.user.gender == 'Female') {
      this.hasPeriodCheck = true;
    } else {
      this.hasPeriodCheck = false;
    }
  }

  checkPiercingOrTattoInLast6Month() {
    console.log(this.piercingOrTattooInLast6Month)
    if (this.piercingOrTattooInLast6Month == null) {
      this.piercingOrTattooInLast6MonthCheck = true;
    } else {
      this.piercingOrTattooInLast6MonthCheck = false;
    }
  }

  sendQuestionnaire() {


    if (this.isDonor == null) {
      this.isDonorCheck = true;
    } else if (this.isAbleToDonate == null) {
      this.isAbleToDonateCheck = true;
    } else if (this.foodConsume == null) {
      this.foodConsumeCheck = true;
    }else if (this.takeMedicineRegulary == null) {
      this.takeMedicineRegularyCheck = true;
    }else if (this.takeMedicineThreeDaysAgo == null) {
      this.takeMedicineThreeDaysAgoCheck = true;
    }else if (this.usedAspirin == null) {
      this.usedAspirinCheck = true;
    }else if (this.toothExtractionSevenDaysAgo == null) {
      this.toothExtractionSevenDaysAgoCheck = true;
    }else if (this.hasFeverOrFlu == null) {
      this.hasFeverOrFluCheck = true;
    }else if (this.tickBite12MonthsAgo == null) {
      this.tickBite12MonthsAgoCheck = true;
    }else if (this.curedOfSomeDiseases == null) {
      this.curedOfSomeDiseasesCheck = true;
    } else if (this.suffersFromChronicDiseases == null) {
      this.suffersFromChronicDiseasesCheck = true;
    } else if (this.hasProblemWithGlands == null) {
      this.hasProblemWithGlandsCheck = true;
    } else if (this.hasSkinDiseases == null) {
      this.hasSkinDiseasesCheck = true;
    } else if (this.decreasedPlatelets == null) {
      this.decreasedPlateletsCheck = true;
    } else if (this.hasSurgeryInLast6Month == null) {
      this.hasSurgeryInLast6MonthCheck = true;
    } else if (this.piercingOrTattooInLast6Month == null) {
      console.log("OK")
      this.piercingOrTattooInLast6MonthCheck = true;
    } else if (this.drinkAlcohol == null) {
      this.drinkAlcoholCheck = true;
    } else if (this.lowBloodPressure == null) {
      this.lowBloodPressureCheck = true;
    } else if (this.bloodTransfusionInLast6Months == null) {
      this.bloodTransfusionInLast6MonthsCheck = true;
    } else if (this.lessThan50Kilograms == null) {
      this.lessThan50KilogramsCheck = true;
    } else if (this.isPregnant == null && this.user.gender == 'Female') {
      this.isPregnantCheck = true;
    } else if (this.hasPeriod == null && this.user.gender == 'Female') {
      this.hasPeriodCheck = true;
    } 
    else {
      let data = {
        isDonor: this.isDonor,
        isAbleToDonate: this.isAbleToDonate,
        foodConsume: this.foodConsume,
        takeMedicineRegulary: this.takeMedicineRegulary,
        takeMedicineThreeDaysAgo: this.takeMedicineThreeDaysAgo,
        usedAspirin: this.usedAspirin,
        toothExtractionSevenDaysAgo: this.toothExtractionSevenDaysAgo,
        hasFeverOrFlu: this.hasFeverOrFlu,
        tickBite12MonthsAgo: this.tickBite12MonthsAgo,
        curedOfSomeDiseases: this.curedOfSomeDiseases,
        suffersFromChronicDiseases: this.suffersFromChronicDiseases,
        hasProblemWithGlands: this.hasProblemWithGlands,
        hasSkinDiseases: this.hasSkinDiseases,
        decreasedPlatelets: this.decreasedPlatelets,
        hasSurgeryInLast6Month: this.hasSurgeryInLast6Month,
        piercingOrTattooInLast6Month: this.piercingOrTattooInLast6Month,
        drinkAlcohol: this.drinkAlcohol,
        lowBloodPressure: this.lowBloodPressure,
        bloodTransfusionInLast6Months: this.bloodTransfusionInLast6Months,
        lessThan50Kilograms: this.lessThan50Kilograms,
        isPregnant: this.isPregnant,
        hasPeriod: this.hasPeriod,
        username: this.user.username
      }
      this.questionnaireService.createQuestionnaire(data).subscribe((response: any) => {
        console.log(response);
        this.router.navigate(['/'])
      })

    }
  }

}
