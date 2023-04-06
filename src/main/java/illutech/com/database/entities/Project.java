package illutech.com.database.entities;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Collection;

@Entity(name = "project")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String projectName;
    @ManyToMany
    private Collection<Department> departments=new ArrayList<>();
    public Project(){}
    public Project(
            String projectName
    ){
        this.projectName = projectName;
    }
    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Collection<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(Collection<Department> departments) {
        this.departments = departments;
    }
}
