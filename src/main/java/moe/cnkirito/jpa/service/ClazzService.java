package moe.cnkirito.jpa.service;

import moe.cnkirito.jpa.dao.ClazzRepo;
import moe.cnkirito.jpa.model.Clazz;
import moe.cnkirito.jpa.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import javax.annotation.PostConstruct;
import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author xujingfeng
 * @since 2017/11/22
 */
@Service
public class ClazzService {

    @Autowired
    ClazzRepo clazzRepo;

    public void test1() {
        Clazz clazzSpec = new Clazz();
        clazzSpec.setName("三年2班");
        Clazz clazz = clazzRepo.findOne(getSpecification(clazzSpec));
        Assert.isTrue(clazz.getStudents().size() == 2, "数量期望为2");
        clazz.getStudents().get(0).setName("小黄");
        clazz.getStudents().remove(1);
        clazzRepo.saveAndFlush(clazz);
        Clazz updateClazz = clazzRepo.findOne(getSpecification(clazzSpec));
        Assert.isTrue(updateClazz.getStudents().size() == 1, "数量期望为1");
    }

    private Specification<Clazz> getSpecification(Clazz clazz) {
        return (root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            predicates.add(criteriaBuilder.equal(root.get("name"), clazz.getName()));
            return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
        };
    }

    @PostConstruct
    void init() {
        Clazz clazz = new Clazz();
        clazz.setName("三年2班");

        Student student1 = new Student();
        student1.setName("小明");
        student1.setClazz(clazz);

        Student student2 = new Student();
        student2.setName("小红");
        student2.setClazz(clazz);

        clazz.setStudents(Arrays.asList(student1, student2));

        clazzRepo.save(clazz);

    }

}
