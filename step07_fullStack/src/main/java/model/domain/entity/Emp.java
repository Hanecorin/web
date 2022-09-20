package model.domain.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Builder
@Entity
public class Emp {

	@Id
	@Column
	private Long empno;
	
	@Column
	private String ename;
	
	@Column
	private String job;
	
	@Column
	private Long mgr;
	
	@Column
	private Date hiredate;
	
	@Column
	private Long sal;
	
	@Column
	private Long comm;
	

	
	@ManyToOne  
	@JoinColumn(name = "deptno")
	private Dept deptno; 
	
	
	@Override
	public String toString() {
//		return "Employee [사원 아이디 = " + empno + ", 사원명 = " + ename + ", 급여 = " + sal + ", 부서 = " + deptno.getDname() + "]";
		return "Employee [사원 아이디 = " + empno + ", 사원명 = " + ename + ", 급여 = " + sal + "]";
	}
}