package cn.mldn.hh.SpringCloud.service;

import java.util.List;

import cn.mldn.hh.SpringCloud.vo.Dept;

public interface IDeptService {
	public boolean add(Dept vo);
	public Dept get(Long id);
	public List<Dept> list();
}
