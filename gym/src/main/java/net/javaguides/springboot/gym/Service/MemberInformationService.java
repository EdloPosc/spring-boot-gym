package net.javaguides.springboot.gym.Service;

import net.javaguides.springboot.gym.Dao.gymDao;
import net.javaguides.springboot.gym.Model.gymModel;

import java.util.List;

public interface MemberInformationService{
    gymModel getMember(Integer id);
    public void save(gymModel member);
    List<gymModel> getMemberList();
    void updateMember(gymModel member);
    void deleteMember(gymModel member);

}
