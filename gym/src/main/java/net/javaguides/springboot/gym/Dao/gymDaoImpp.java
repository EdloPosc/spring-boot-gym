package net.javaguides.springboot.gym.Dao;

import net.javaguides.springboot.gym.Model.gymModel;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;


@Repository
public class gymDaoImpp implements gymDao {

        @Autowired
        private EntityManager entityManager;

        private Session getSession(){
            return entityManager.unwrap(Session.class);
        }
        @Override
        public void save(gymModel member){
            getSession().save(member);
        }

        @SuppressWarnings("unchecked")
        @Override
        public List<gymModel> getMemberList(){
                return getSession().createCriteria(gymModel.class).list();
        }

        @Override
        public gymModel getMember(Integer id){
                gymModel gymModel = (gymModel)getSession().get(gymModel.class, id);
                return gymModel;
        }
        @Override
        public void updateMember(gymModel member){
                getSession().update(member);
        }
        @Override
        public void deleteMember(gymModel member){
                getSession().delete(member);
        }

}
