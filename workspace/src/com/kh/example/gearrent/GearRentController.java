package com.kh.example.gearrent;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class GearRentController {
	
	private HashMap<String, Device> catalog = new HashMap<>();
	private HashMap<String, Member> members = new HashMap<>();
	private HashMap<String, Loan> activeLoans = new HashMap<>();
	
	public boolean addDevice(Device device) {
		if(catalog.containsKey(device.getId())) {
			catalog.put(device.getId(), device);
			return true;
		} else return false;
	}
	
	public boolean addMember(String memberId, Member member) {
		if(members.containsKey(member.getId())) {
			members.put(memberId, member);
			return true;
		} else return false;
	}
	
	public Loan borrow(String memberId, String itemId, LocalDate today) {
		Device device = catalog.get(itemId);
		LocalDate due = today.plusDays(0)
		
		return Loan;
	}
	
	public int returnItem(String itemId, LocalDate today) {
		
		
		return ;
	}
	
	public ArrayList<Device> findByTag(String tag) {
		
		return ;
	}
	
	public ArrayList<Device> findByKeyword(String keyword) {
		
		return ;
	}
	
	public Collection<Device> getAllDevices() {
		
		return ;
	}
	
	public Collection<Loan> getActiveLoans() {
		
		return;
	}
}
