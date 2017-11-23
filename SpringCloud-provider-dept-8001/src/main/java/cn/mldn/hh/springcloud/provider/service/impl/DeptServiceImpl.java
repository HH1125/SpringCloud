package cn.mldn.hh.springcloud.provider.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.mldn.hh.SpringCloud.service.IDeptService;
import cn.mldn.hh.SpringCloud.vo.Dept;
import cn.mldn.hh.springcloud.provider.dao.IDeptDAO;
@Service
public class DeptServiceImpl implements IDeptService {
	@Resource
	private IDeptDAO deptDAO ;
	@Override
	public boolean add(Dept dept) {
		return this.deptDAO.doCreate(dept);
	}

	@Override
	public Dept get(Long deptno) {
		return this.deptDAO.findById(deptno);
	}

	@Override
	public List<Dept> list() {
		return this.deptDAO.findAll(); 
	}

}
