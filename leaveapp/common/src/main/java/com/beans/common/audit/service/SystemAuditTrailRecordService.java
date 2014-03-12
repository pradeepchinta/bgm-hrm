package com.beans.common.audit.service;

import java.util.List;

import com.beans.common.audit.model.SystemAuditTrail;

public interface SystemAuditTrailRecordService {

	public SystemAuditTrail create(SystemAuditTrail systemAuditTrail);
	public SystemAuditTrail delete(int id) throws Exception;
	
	public List<SystemAuditTrail> findAll();
	public SystemAuditTrail update(SystemAuditTrail systemAuditTrail) throws Exception;
	public SystemAuditTrail findById(int id) throws Exception;
	
	
	
	
	
}
