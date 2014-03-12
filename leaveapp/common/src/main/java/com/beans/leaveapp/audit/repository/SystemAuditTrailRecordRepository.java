package com.beans.leaveapp.audit.repository;

import java.sql.Date;
import java.util.List;

import com.beans.common.audit.model.SystemAuditTrail;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface SystemAuditTrailRecordRepository extends CrudRepository<SystemAuditTrail, Integer>{

	
	 @Query("select l from SystemAuditTrail l where isDeleted = ?")
	 List<SystemAuditTrail> findByisDeleted(int x);
	 
	/* @Query("select l from SystemAuditTrail l where date = ?")
	  List<SystemAuditTrail> findByDate(Date x);*/
	
	
	
	
}
