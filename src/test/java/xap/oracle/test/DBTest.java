package xap.oracle.test;

import org.springframework.context.support.FileSystemXmlApplicationContext;

import xap.oracle.employee.dao.EmployeeDAO;
import xap.oracle.employee.entity.Employee;

public class DBTest {

	public static void main(String[] args) throws InterruptedException {

		FileSystemXmlApplicationContext context = new FileSystemXmlApplicationContext(
				"classpath:/spring/test-context.xml");

		EmployeeDAO service = context.getBean(EmployeeDAO.class);

		int timer = 3000;

		Employee emp = new Employee();

		for (int i = 0; i < 10; i++) {

			emp.setAge(10);
			emp.setFistName("John");
			emp.setLastName("Dow" + i);
			emp.setId(new Long(i));
			emp.setProcessed(Boolean.FALSE);
			emp.setDepartmentId(i % 5);

			System.out.println("Creating an Employee");
			service.create(emp);
			Thread.sleep(timer);

		}

		for (int i = 0; i < 10; i++) {
			emp.setAge(22);
			emp.setFistName("Fritz");
			emp.setLastName("Shultz" + i);
			emp.setId(new Long(i));
			emp.setProcessed(Boolean.TRUE);
			emp.setDepartmentId(i % 5);

			System.out.println("Updating an Employee");
			service.update(emp);
			Thread.sleep(timer);

		}

		for (int i = 0; i < 10; i++) {
			emp.setId(new Long(i));

			System.out.println("Deleting an Employee");
			service.remove(emp);
			Thread.sleep(timer);
		}
	}

}
