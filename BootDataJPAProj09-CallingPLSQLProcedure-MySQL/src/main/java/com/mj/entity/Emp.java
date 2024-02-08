package com.mj.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "EMP") //optional if you want to make db table name same as entity class name
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Emp implements Serializable {
	@Id
	@Column(name = "empno")
	private Long empNO;
	@Column(length = 20)
	private String ename;
	@Column(length = 20)
	private String job;
	@Column
	private Float sal;
}
