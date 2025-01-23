package com.flipkart.business;

import com.flipkart.bean.GymCentre;
import com.flipkart.bean.Slot;
import com.flipkart.dao.GymOwnerDaoImpl;

import java.util.List;

public class GymOwnerService {
	
	GymOwnerDaoImpl gymOwnerDao = new GymOwnerDaoImpl();
	
    public boolean addGym(GymCentre gymCentre) {
    	return gymOwnerDao.addGym(gymCentre);
    }

    public boolean updateGym(GymCentre gymCentre) {
    	return gymOwnerDao.updateGym(gymCentre);
    }

    public boolean addSlotToGym(int gymId, Slot slot) {
        return gymOwnerDao.addSlotToGym(gymId, slot);
    }

    public List<GymCentre> getGymsForOwner(int ownerId) {
        return gymOwnerDao.getGymsForOwner(ownerId);
    }
    
}
