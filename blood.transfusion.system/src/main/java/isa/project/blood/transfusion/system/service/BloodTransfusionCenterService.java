package isa.project.blood.transfusion.system.service;

import java.util.List;

import isa.project.blood.transfusion.system.dto.SortDTO;
import isa.project.blood.transfusion.system.model.BloodTransfusionCenter;

public interface BloodTransfusionCenterService {

	public List<BloodTransfusionCenter> getAll();
	public List<BloodTransfusionCenter> sort(SortDTO sortDTO);
	public BloodTransfusionCenter getById(Long id);
}
