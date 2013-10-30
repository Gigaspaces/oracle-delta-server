package xap.oracle.employee.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import xap.model.AbstractJpaDAO;
import xap.oracle.employee.entity.Employee;

@Service
public class EmployeeDAO extends AbstractJpaDAO<Employee, Long> {

	Logger logger = LoggerFactory.getLogger(EmployeeDAO.class);

	public void create(Employee employee) {
		super.persist(employee);
	}

	public void update(Employee employee) {
		super.update(employee);
	}

	public void remove(Employee employee) {
		super.remove(employee);
	}

	public Employee findEmloyeeById(Long id) {
		Session session = this.getSession();

		Query query = session.getNamedQuery("findEmployeeById").setLong("id",
				id);

		if (logger.isDebugEnabled())
			logger.debug(query.toString());

		return (Employee) query.uniqueResult();
	}

	public Employee findEmloyeeByRowId(String id) {
		Session session = this.getSession();

		Query query = session.getNamedQuery("findEmployeeByRowId").setString(
				"rowId", id);

		if (logger.isDebugEnabled())
			logger.debug(query.toString());

		return (Employee) query.uniqueResult();
	}

	public Employee findEmloyeeByDepartment(Long departmentId) {
		Session session = this.getSession();

		Query query = session.getNamedQuery("findEmployeeByDepartmentId")
				.setLong("departmentId", departmentId);

		if (logger.isDebugEnabled())
			logger.debug(query.toString());

		return (Employee) query.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public List<Employee> findEmloyeesByRowIds(List<String> ids) {
		Session session = this.getSession();

		Query query = session.getNamedQuery("findEmployeesByRowIds")
				.setParameterList("rowIds", ids);

		if (logger.isDebugEnabled())
			logger.debug(query.toString());

		return query.list();
	}

	@Override
	protected Class<?> getKlass() {
		return Employee.class;
	}
}
