package illutech.com.database.dao.entities;
import illutech.com.database.Configuration.databaseConfiguration;
import illutech.com.database.dao.entities.subentities.Contact;
import illutech.com.database.dao.entities.subentities.Gender;
import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import org.hibernate.Session;
import java.util.List;
import java.util.Optional;

@Entity(name = "Employee")
public class Employee {
    @ManyToOne(targetEntity = Department.class)
    @JoinColumn(nullable = true)
    private Department department;
    @Embedded
    @JoinColumn(nullable = true)
    private Contact contact;
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "national_id")
    private int nationalId=-999999;
    @Column(name = "age")
    private int age;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email_address")
    private String emailAddress;
    @Column(name = "gender",nullable = true)

    @Enumerated(EnumType.STRING)
    private Gender gender;
    //empty constructor
    public Employee(){

    }

    public Employee(Department department, Contact contact, int id, int nationalId, int age, String firstName,
                    String lastName, String emailAddress, Gender gender) {
        this.department = department;
        this.contact = contact;
        this.id = id;
        this.nationalId = nationalId;
        this.age = age;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.gender = gender;
    }
    public Employee(Department department, Contact contact, int age, String firstName,int nationalId,
                    String lastName, String emailAddress, Gender gender) {
        this.contact = contact;
        this.department = department;
        this.nationalId = nationalId;
        this.age = age;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.gender = gender;
    }

    public int getNationalId() {
        return nationalId;
    }

    public void setNationalId(int nationalId) {
        this.nationalId = nationalId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }



    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }




    public void getInfo(){
        System.out.println(this.getId()+"\t"+this.getAge()+"\t"+this.getFirstName()+"\t"+this.getLastName()+"\t"+this.getNationalId()+"\t"+this.getDepartment().getDepartmentName()
                                   +"\t"+this.getContact().getContactType()+": "+this.getContact().getCountryCode()+this.getContact().getNumber()
                                   +"\t"+this.getGender()+"\t"+this.getEmailAddress());
    }
    public void readEmployees(){

       Session session =  databaseConfiguration.Config();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Employee> employeeCriteriaQuery = criteriaBuilder.createQuery(Employee.class);
        employeeCriteriaQuery.from(Employee.class);
        List<Employee> employees =session.createQuery(employeeCriteriaQuery).getResultList();
        for (var elem :
                employees) {

            System.out.println(elem.getId()+" "+elem.getFirstName()+elem.getDepartment().getDepartmentName());

        }

    }
    public void readEmployee(int id){

        List<Employee> employees;
        try (Session session = databaseConfiguration.Config()) {
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<Employee> employeeCriteriaQuery = criteriaBuilder.createQuery(Employee.class);
            employeeCriteriaQuery.from(Employee.class);
            employees = session.createQuery(employeeCriteriaQuery).getResultList();
        }
        Optional<Employee> element =  employees.stream().filter(p->p.id==id).findFirst().map(p-> {
            p.getInfo();
            return p;
        });


    }

}
