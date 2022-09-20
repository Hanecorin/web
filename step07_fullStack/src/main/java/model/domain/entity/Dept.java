package model.domain.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

@Entity
public class Dept {
	@Id
	private int deptno;
	
	@Column(length = 20)
	private String dname;
	
	@Column(length = 20)
	private String loc;
}
