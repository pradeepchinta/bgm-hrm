package com.beans.leaveapp.leavetype.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.event.SelectEvent;

import com.beans.leaveapp.leavetype.model.LeaveType;
import com.beans.leaveapp.leavetype.model.LeaveTypeDataModel;
import com.beans.leaveapp.leavetype.service.LeaveTypeNotFound;
import com.beans.leaveapp.leavetype.service.LeaveTypeService;

public class LeaveTypeManagementBean implements Serializable{
	private static final long serialVersionUID = 1L;
	
	LeaveTypeService leaveTypeService;
	private List<LeaveType> leaveTypeList;
	private LeaveTypeDataModel leaveTypeDataModel;
	private LeaveType newLeaveType = new LeaveType();
	private LeaveType selectedLeaveType = new LeaveType();
	private boolean insertDelete = false;
	
	public LeaveTypeService getLeaveTypeService() {
		return leaveTypeService;
	}
	
	public void setLeaveTypeService(LeaveTypeService leaveTypeService) {
		this.leaveTypeService = leaveTypeService;
	}
	
	public List<LeaveType> getLeaveTypeList() {
		if(leaveTypeList == null || insertDelete == true) {
			leaveTypeList = getLeaveTypeService().findAll();			
		}		
		
		return leaveTypeList;
	}
	
	public void setLeaveTypeList(List<LeaveType> leaveTypeList) {
		this.leaveTypeList = leaveTypeList;
	}
	
	public LeaveTypeDataModel getLeaveTypeDataModel() {
		if(leaveTypeDataModel == null || insertDelete == true) {
			leaveTypeDataModel = new LeaveTypeDataModel(getLeaveTypeList());
		}
		return leaveTypeDataModel;
	}
	
	public void setLeaveTypeDataModel(LeaveTypeDataModel leaveTypeDataModel) {
		this.leaveTypeDataModel = leaveTypeDataModel;
	}
	
	
	public LeaveType getNewLeaveType() {
		return newLeaveType;
	}
	
	public void setNewLeaveType(LeaveType newLeaveType) {
		this.newLeaveType = newLeaveType;
	}
	
	public void doCreateLeaveType() {
		getLeaveTypeService().create(newLeaveType);
		setInsertDelete(true);
	}
	
	public LeaveType getSelectedLeaveType() {
		return selectedLeaveType;
	}
	public void setSelectedLeaveType(LeaveType selectedLeaveType) {
		this.selectedLeaveType = selectedLeaveType;
	}
	
	public void doUpdateLeaveType() {
		try {
			System.out.println("New name:" + selectedLeaveType.getName());
			System.out.println("ID: " + selectedLeaveType.getId());
			getLeaveTypeService().update(selectedLeaveType);
		} catch(LeaveTypeNotFound e) {
			FacesMessage msg = new FacesMessage("Error", "Leave Type With id: " + selectedLeaveType.getId() + " not found!");  
			  
	        FacesContext.getCurrentInstance().addMessage(null, msg);  
		}
	}
	
	public void onRowSelect(SelectEvent event) {  
		setSelectedLeaveType((LeaveType) event.getObject());
        FacesMessage msg = new FacesMessage("Leave Type Selected", selectedLeaveType.getName());  
        
        FacesContext.getCurrentInstance().addMessage(null, msg);  
    }  
	
	public void doDeleteLeaveType() {
		try {
			getLeaveTypeService().delete(selectedLeaveType.getId());
		} catch(LeaveTypeNotFound e) {
			FacesMessage msg = new FacesMessage("Error", "Leave Type With id: " + selectedLeaveType.getId() + " not found!");  
			  
	        FacesContext.getCurrentInstance().addMessage(null, msg);  
		}
		
		setInsertDelete(true);
	}
	
	public void setInsertDelete(boolean insertDelete) {
		this.insertDelete = insertDelete;
	}
	
	public boolean isInsertDelete() {
		return insertDelete;
	}
	
} 
