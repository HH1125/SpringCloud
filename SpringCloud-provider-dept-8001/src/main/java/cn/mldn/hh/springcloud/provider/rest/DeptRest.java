package cn.mldn.hh.springcloud.provider.rest;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import cn.mldn.hh.SpringCloud.service.IDeptService;
import cn.mldn.hh.SpringCloud.vo.Dept;

@RestController
public class DeptRest {
	@Resource
	private IDeptService deptService ;
	/**
	 * 添加操作需要以Post请求方式提交 参数中需要添加注解@RequestBody
	 * @param dept
	 * @return
	 */
	@PostMapping("/dept/add")
	public Object add(@RequestBody Dept dept) {
		return this.deptService.add(dept) ;
	}
	/**
	 * 列表显示，正常访问。无需额外添加配置
	 * @return
	 */
	@GetMapping("/dept/list")
	public Object list() {
		return this.deptService.list() ;
	}
	@GetMapping("/dept/session")
	public Object session(HttpServletRequest request) {
		return request.getSession().getId();
	}
	/**
	 * 此处需要添加@PathVariable("deptno")注解，否则无法正常访问。
	 * 访问地址也需要修改@GetMapping("/dept/get/{deptno}")添加参数/{id}注意"/"
	 * @param deptno 部门表编号
	 * @return 以Rest风格返回查询结果
	 */
	@GetMapping("/dept/get/{deptno}")
	public Object get(@PathVariable("deptno") long deptno) {
		return this.deptService.get(deptno) ; 
	}
}
