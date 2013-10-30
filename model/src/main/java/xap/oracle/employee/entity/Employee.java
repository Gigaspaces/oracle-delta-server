package xap.oracle.employee.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

import xap.model.IDomainEntity;

import com.gigaspaces.annotation.pojo.SpaceClass;
import com.gigaspaces.annotation.pojo.SpaceId;
import com.gigaspaces.annotation.pojo.SpaceRouting;

@SpaceClass
@NamedNativeQueries({ @NamedNativeQuery(name = "findEmployeesByRowIds", query = "select * from Employee e where e.rowid IN (:rowIds)", resultClass = Employee.class) })
@NamedQueries({
		@NamedQuery(name = "findEmployeeByRowId", query = "from Employee e where rowid = :rowId"),
		@NamedQuery(name = "findEmployeeById", query = "from Employee e where id = :id"),
		@NamedQuery(name = "findEmployeeByDepartmentId", query = "from Employee e where department_id = :departmentId") })
@Entity(name = "Employee")
@Table(name = "employee")
public class Employee implements IDomainEntity<Long> {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", unique = true, nullable = false, precision = 38, scale = 0)
	private Long id;

	@Transient
	private String rowid;

	@Column(name = "PROCESSED", nullable = false)
	private Boolean processed;

	@Column(name = "FIRST_NAME", nullable = false, length = 255)
	private String fistName;

	@Column(name = "LAST_NAME", nullable = false, length = 255)
	private String lastName;

	@Column(name = "AGE", nullable = false)
	private Integer age;

	@Column(name = "DEPARTMENT_ID", nullable = false)
	private Integer departmentId;

	public Employee() {
	}

	@SpaceId(autoGenerate = false)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Boolean getProcessed() {
		return processed;
	}

	public void setProcessed(Boolean processed) {
		this.processed = processed;
	}

	public String getFistName() {
		return fistName;
	}

	public void setFistName(String fistName) {
		this.fistName = fistName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@SpaceRouting
	public Integer getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Integer department) {
		this.departmentId = department;
	}

	public String getRowid() {
		return rowid;
	}

	public void setRowid(String rowid) {
		this.rowid = rowid;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Employee [id=").append(id).append(", rowid=")
				.append(rowid).append(", processed=").append(processed)
				.append(", fistName=").append(fistName).append(", lastName=")
				.append(lastName).append(", age=").append(age)
				.append(", departmentId=").append(departmentId).append("]");
		return builder.toString();
	}
}
