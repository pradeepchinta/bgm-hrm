package com.beans.leaveapp.audit.trail.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.event.SelectEvent;

import com.beans.common.audit.model.SystemAuditTrail;
import com.beans.common.audit.service.SystemAuditTrailRecordService;
import com.beans.leaveapp.audittrail.model.SystemAuditTrailDataModel;

public class SystemAuditTrailManagementBean implements Serializable {
private static final long serialVersionUID = 1L;
	
	// EmployeeGradeRepository employeeGradeRepository;
    private SystemAuditTrailRecordService systemAuditTrailService;
	private List<SystemAuditTrail> systemAuditTrailList;
	private SystemAuditTrailDataModel systemAuditTrailDataModel;
	

	private SystemAuditTrail newSystemAuditTrail = new SystemAuditTrail();
	private SystemAuditTrail selectedSystemAuditTrail = new SystemAuditTrail();
	private boolean insertDeleted = false;



	public SystemAuditTrailRecordService getSystemAuditTrailService() {
		return systemAuditTrailService;
	}

	public void setSystemAuditTrailService(
			SystemAuditTrailRecordService systemAuditTrailService) {
		this.systemAuditTrailService = systemAuditTrailService;
	}

	
	
	public SystemAuditTrail getNewSystemAuditTrail() {
		return newSystemAuditTrail;
	}

	public void setNewSystemAuditTrail(SystemAuditTrail newSystemAuditTrail) {
		this.newSystemAuditTrail = newSystemAuditTrail;
	}

	
	
	public SystemAuditTrail getSelectedSystemAuditTrail() {
		return selectedSystemAuditTrail;
	}

	public void setSelectedSystemAuditTrail(
			SystemAuditTrail selectedSystemAuditTrail) {
		this.selectedSystemAuditTrail = selectedSystemAuditTrail;
	}

	public boolean isInsertDeleted() {
		return insertDeleted;
	}

	public void setInsertDelete(boolean insertDeleted) {
		this.insertDeleted = insertDeleted;
	}

	
	public List<SystemAuditTrail> getSystemAuditTrailList() {
		if(systemAuditTrailList == null || insertDeleted == true) {
			 try {
				 systemAuditTrailList = getSystemAuditTrailService().findAll();
			} catch (Throwable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return systemAuditTrailList;	
	}
	
	public void setSystemAuditTrailDataModel(
			SystemAuditTrailDataModel systemAuditTrailDataModel) {
		this.systemAuditTrailDataModel = systemAuditTrailDataModel;
	}
	
	public SystemAuditTrailDataModel getSystemAuditTrailDataModel() {
		if(systemAuditTrailDataModel == null || insertDeleted == true) {
			systemAuditTrailDataModel = new SystemAuditTrailDataModel(getSystemAuditTrailList());
		}
		
		return systemAuditTrailDataModel;
	}

	
	public void setSystemAuditTrailList( List<SystemAuditTrail> systemAuditTrailLists) {
		this.systemAuditTrailList = systemAuditTrailLists;
	}

	public void doCreateSystemAuditTrail() throws Exception {
		getSystemAuditTrailService().create(newSystemAuditTrail);
		setInsertDelete(true);
	}
	
	public void doUpdateSystemAuditTrail() throws Exception {
		try {
			System.out.println("DATE:" + selectedSystemAuditTrail.getDate());
			System.out.println("ID: " + selectedSystemAuditTrail.getId());
			System.out.println("ActorUserId: " + selectedSystemAuditTrail.getActotUserId());
			System.out.println("Description: " + selectedSystemAuditTrail.getDescription());
			getSystemAuditTrailService().update(selectedSystemAuditTrail);
		// RequestContext.getCurrentInstance().
		} catch(Exception e) {
			FacesMessage msg = new FacesMessage("Error", "Leave Type With id: " + selectedSystemAuditTrail.getId() + " not found!");  
			  
	        FacesContext.getCurrentInstance().addMessage(null, msg);  
		}
	}
	
	public void onRowSelect(SelectEvent event) {  
		setSelectedSystemAuditTrail((SystemAuditTrail) event.getObject());
        FacesMessage msg = new FacesMessage("Leave Type Selected", selectedSystemAuditTrail.getDescription());  // need to update
        
        FacesContext.getCurrentInstance().addMessage(null, msg);  
    }  
	
	
	public void doDeleteSystemAuditTrail() {
		try {
			getSystemAuditTrailService().delete(selectedSystemAuditTrail.getId());
		} catch(Exception e) {
			FacesMessage msg = new FacesMessage("Error", "Leave Type With id: " + selectedSystemAuditTrail.getId() + " not found!");  
			  
	        FacesContext.getCurrentInstance().addMessage(null, msg);  
		}
		
		setInsertDelete(true);
	}
	
	public void doResetFrom() throws Exception {
		
	}
}
