package com.mj;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.mj.controller.MainController;
import com.mj.vo.EmployeeVO;

@SpringBootApplication
public class BootProj4RealTimeDiAutoConfigurationApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=	SpringApplication.run(BootProj4RealTimeDiAutoConfigurationApplication.class, args);
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
			// TODO Auto-generated catch block
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
		return cond;
	}

}
//ctrl+shift+T   and search for DataSourceAutoConfiguration then you can see auto configured datasource classes
