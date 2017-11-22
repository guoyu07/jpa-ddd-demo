package moe.cnkirito.jpa.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

/**
 * @author xujingfeng
 * @since 2017/11/22
 */
@Entity
public class Clazz {

    @Id
    @GenericGenerator(name = "PKUUID", strategy = "uuid2")
    @GeneratedValue(generator = "PKUUID")
    private String id;

    private String name;

    @OneToMany(cascade = {CascadeType.ALL}, orphanRemoval = true, fetch = FetchType.LAZY, mappedBy = "clazz")
    private List<Student> students;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
