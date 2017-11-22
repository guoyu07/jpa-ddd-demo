package moe.cnkirito.jpa.dao;

import moe.cnkirito.jpa.model.Clazz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author xujingfeng
 * @since 2017/11/22
 */
public interface ClazzRepo extends JpaRepository<Clazz, String>,JpaSpecificationExecutor<Clazz> {

}
