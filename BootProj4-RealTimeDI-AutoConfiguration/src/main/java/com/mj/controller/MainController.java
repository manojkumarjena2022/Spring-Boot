package com.mj.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.mj.dto.EmployeeDTO;
import com.mj.service.IEmployeeService;
import com.mj.vo.EmployeeVO;

@Controller("controller")
public class MainController {
	@Autowired
	IEmployeeService service;
	public List<EmployeeVO> displayEmpsByDesgs(String cond) throws Exception{
		List<EmployeeDTO> listDTO=service.fetchEmpByDesgs(cond);
		//convet list DTO to list VO
		List<EmployeeVO> listVO=new ArrayList<EmployeeVO>();
		EmployeeVO vo=null;
		int srNo=0;
		for (EmployeeDTO dto : listDTO) {
			vo=new EmployeeVO();
			vo.setSrNo(String.valueOf(++srNo));
			vo.setEmpNo(String.valueOf(dto.getEmpNo()));
			vo.setEname(dto.getEname());
			vo.setJob(dto.getJob());
			vo.setDeptNo(String.valueOf(dto.getDeptNo()));
			vo.setMgr(String.valueOf(dto.getMgr()));
			vo.setSal(String.valueOf(dto.getSal()));
			vo.setComm(String.valueOf(dto.getComm()));
			vo.setHireDate(dto.getHireDate());
			listVO.add(vo);
		}

		return listVO;
	}
}
