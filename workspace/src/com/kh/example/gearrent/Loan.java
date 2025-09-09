package com.kh.example.gearrent;

import java.time.LocalDate;

public class Loan {
	
	private String itemId;
	private String memberId;
	private LocalDate loanDate;
	private LocalDate dueDate;
	private LocalDate returnedDate;
	
	public Loan() {
		super();
	}

	public Loan(String itemId, String memberId, LocalDate loanDate, LocalDate dueDate, LocalDate returnedDate) {
		super();
		this.itemId = itemId;
		this.memberId = memberId;
		this.loanDate = loanDate;
		this.dueDate = dueDate;
		this.returnedDate = returnedDate;
	}
	
	public boolean isOverdue(LocalDate today) {
		if(returnedDate != null) {
			today = returnedDate;
		}
		else {
			if(today.compareTo(dueDate) > 0) {
				return true;
			}
			else return false;
		}
		return false;
	}
	
	public int isOverdueDays(LocalDate today) {
		if(returnedDate != null) {
			today = returnedDate;
		}
		else {
			if(today.compareTo(dueDate) > 0) {
				return today.compareTo(dueDate);
			}
			else return 0;
		}
		return 0;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	
	
	
}
