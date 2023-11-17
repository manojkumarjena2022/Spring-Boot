package com.mj;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mj.controller.MainController;
import com.mj.vo.EmployeeVO;

@SpringBootApplication
public class BootProj4RealTimeDiAutoConfigurationApplication {
	@Autowired
	Environment env;
	@Bean(name = "c3p0Ds")
	@Profile("uat")
	public ComboPooledDataSource createC3P0Ds() throws Exception{
		System.out.println("BootProj4RealTimeDiAutoConfigurationApplication.createC3P0Ds()");
		ComboPooledDataSource c3PODs=new ComboPooledDataSource();
		c3PODs.setDriverClass(env.getProperty("spring.datasource.driver-class-name"));
		c3PODs.setJdbcUrl(env.getProperty("spring.datasource.url"));
		c3PODs.setUser(env.getProperty("spring.datasource.username"));
		c3PODs.setPassword(env.getProperty("spring.datasource.password"));
		return c3PODs;
	}

	public static void main(String[] args) {
		ApplicationContext ctx=	SpringApplication.run(BootProj4RealTimeDiAutoConfigurationApplication.class, args);
		
		//Programmatic approach to set active profile
		/*
		 * SpringApplication application=new
		 * SpringApplication(BootProj4RealTimeDiAutoConfigurationApplication.class);
		 * application.setAdditionalProfiles("test"); ApplicationContext
		 * ctx=application.run(args);
		 */
		
		MainController controller=ctx.getBean("controller",MainController.class);
		
		String input=getInput();
		if(input=="")
		{
			System.out.println("No Employee Found !");
			return;
		}

		try {
			List<EmployeeVO> listVO=controller.displayEmpsByDesgs(input);
			for (EmployeeVO employeeVO : listVO) {
				System.out.println(employeeVO);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}


	}
	private static String getInput() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter number of designations you want to search for :");
		int count=sc.nextInt();
		String cond="";
		for(int i=1;i<=count;i++) {
			System.out.println(i+". Enter designation :");
			String desg=sc.next();
			if(i==1)
			{
				cond="'"+desg+"'";
			}
			else
			{
				cond+=","+"'"+desg+"'";
			}
		}
		sc.close();
		return cond;
	}

}
//ctrl+shift+T   and search for DataSourceAutoConfiguration then you can see auto configured datasource classes
