package net.javaguides.springboot.gym.Dao;

import net.javaguides.springboot.gym.Model.gymModel;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface gymDao {
    gymModel getMember(Integer id);
    void save(gymModel member);
    List<gymModel> getMemberList();
    void updateMember(gymModel member);
    void deleteMember(gymModel member);
}
