package net.javaguides.springboot.gym.Service;

import net.javaguides.springboot.gym.Dao.gymDao;
import net.javaguides.springboot.gym.Model.gymModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class MemberInformationServiceImp implements MemberInformationService {

    @Autowired
    private gymDao memberDao;

    @Override
    public void save(gymModel member){
        memberDao.save(member);
    }

    @Override
    public List<gymModel> getMemberList(){
        return memberDao.getMemberList();
    }

    @Override
    public gymModel getMember(Integer id){
        return memberDao.getMember(id);
    }

    @Override
    public void updateMember(gymModel member){
        memberDao.updateMember(member);
    }
    @Override
    public void deleteMember(gymModel member){
        memberDao.deleteMember(member);
    }
}
