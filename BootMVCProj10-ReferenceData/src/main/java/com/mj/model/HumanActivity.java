package com.mj.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Entity
@Table(name = "HUMAN_ACTIVITIES")
@Data
public class HumanActivity {
	@Id
	private String hobbies;
}
