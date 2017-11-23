package cn.mldn.hh.springcloud.provider.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import cn.mldn.hh.SpringCloud.vo.Dept;
@Mapper 
public interface IDeptDAO {
	public boolean doCreate(Dept dept) ;
	public Dept findById(Long deptno) ;
	public List<Dept> findAll() ; 
}
