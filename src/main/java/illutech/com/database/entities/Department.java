package illutech.com.database.entities;
import jakarta.persistence.*;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
@Entity(name = "department")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @OneToMany(mappedBy = "department")
    private Collection<Employee> employees = new ArrayList<>();
    @ManyToMany(mappedBy = "departments")
    private Collection<Project> projects = new ArrayList<>();
    private String departmentName;
    public Department(String departmentName)
    {
        this.departmentName = departmentName;
    }
    public void setEmployees(Collection<Employee> employees) {
        this.employees = employees;
    }
    public Department() {
    }
    public Collection<Employee> getEmployees() {
        return employees;
    }
    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getDepartmentName() {
        return departmentName;
    }
    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
    public Collection<Project> getProjects() {
        return projects;
    }
    public void setProjects(Collection<Project> projects) {
        this.projects = projects;
    }
}
