package com.beans.common.audit.service;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.beans.common.audit.model.SystemAuditTrail;
import com.beans.leaveapp.audit.repository.SystemAuditTrailRecordRepository;

@Service
public class SystemAuditTrailRecordServiceImpl implements SystemAuditTrailRecordService {

	@Resource
	SystemAuditTrailRecordRepository systemAuditTrailRecordRepository;
	
	@Override
	@Transactional
	public SystemAuditTrail create(SystemAuditTrail systemAuditTrail) {
		SystemAuditTrail s = systemAuditTrail;
		return systemAuditTrailRecordRepository.save(s);
	}

	@Override
	@Transactional
	public SystemAuditTrail delete(int id) throws Exception {
		SystemAuditTrail ss = systemAuditTrailRecordRepository.findOne(id);
		if(ss == null) throw new Exception();
			ss.setDeleted(false);
			systemAuditTrailRecordRepository.save(ss);
			return ss;
	}

	@Override
	public List<SystemAuditTrail> findAll() {
		List<SystemAuditTrail> l =  systemAuditTrailRecordRepository.findByisDeleted(0);
		return l;
	}

	@Override
	public SystemAuditTrail update(SystemAuditTrail systemAuditTrail)
			throws Exception {
		SystemAuditTrail systemAuditTrailRecord =  systemAuditTrailRecordRepository.findOne(systemAuditTrail.getId());
		if(systemAuditTrailRecord == null)
			throw new Exception();
		systemAuditTrailRecord.setDate(systemAuditTrail.getDate());
		systemAuditTrailRecord.setActotUserId(systemAuditTrail.getActotUserId());
		systemAuditTrailRecord.setDescription(systemAuditTrail.getDescription());
		systemAuditTrailRecord.setDeleted(systemAuditTrail.isDeleted());
		systemAuditTrailRecordRepository.save(systemAuditTrailRecord);
		return systemAuditTrailRecord;
	}

	@Override
	public SystemAuditTrail findById(int id) throws Exception {
		SystemAuditTrail systemAuditTrail  = systemAuditTrailRecordRepository.findOne(id);
		if(systemAuditTrail == null)
			throw new Exception();
		return systemAuditTrail;
		
	}
}
