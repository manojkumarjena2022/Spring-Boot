package com.mj.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.mj.bo.EmployeeBO;
import com.mj.dao.IEmployeeDAO;
import com.mj.dto.EmployeeDTO;

@Service("empService")
public class EmployeeServiceImpl implements IEmployeeService {
	@Autowired
	IEmployeeDAO dao;
	@Override
	public List<EmployeeDTO> fetchEmpByDesgs(String cond) throws Exception {
		List<EmployeeDTO> listDTO=new ArrayList<EmployeeDTO>();
		List<EmployeeBO> listBO=dao.getEmpsByDesg(cond);
		//convert listBO to ListDTO
		/*
		 * int srNo=0;
		 * for (EmployeeBO bo : listBO) { dto=new EmployeeDTO(); dto.setSrNo(++srNo);
		 * dto=new EmployeeDTO(); dto.setEmpNo(bo.getEmpNo());
		 * dto.setEname(bo.getEname()); dto.setJob(bo.getJob());
		 * dto.setDeptNo(bo.getDeptNo()); dto.setMgr(bo.getMgr());
		 * dto.setSal(bo.getSal()); dto.setComm(bo.getComm());
		 * dto.setHireDate(bo.getHireDate()); listDTO.add(dto); }
		 */
		listBO.forEach(bo->{
			EmployeeDTO dto=new EmployeeDTO();
			//copy each bo class object to dto class object
			BeanUtils.copyProperties(bo, dto);
			dto.setSrNo(listDTO.size()+1);
			listDTO.add(dto);
		});

		return listDTO;
	}

}
