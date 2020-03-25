package net.javaguides.springboot.gym.Controller;
import net.javaguides.springboot.gym.Service.MemberInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import net.javaguides.springboot.gym.Model.gymModel;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class MemberController {

    @Autowired
    private MemberInformationService MemberInformationService;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(Model model){
        List<gymModel> gymDao = MemberInformationService.getMemberList();
        model.addAttribute("gymDao", gymDao);
        return "index";
    }
    @RequestMapping(value = "edit/{id}", method = RequestMethod.GET)
        public String editMemberPage(Model model, @PathVariable("id") Integer id){
        gymModel member = MemberInformationService.getMember(id);
            model.addAttribute("member", member);
            return "edit";
        }
    @RequestMapping(value = "edit/{id}", method = RequestMethod.POST)
        public String editMember(@PathVariable int id, gymModel member){
        gymModel members = MemberInformationService.getMember(id);

        members.setAdi(member.getAdi());
        members.setSoyadi(member.getSoyadi());
        members.setTelefon(member.getTelefon());
        MemberInformationService.updateMember(members);
        return "redirect:/index/";
    }
    @RequestMapping(value = "/memberDelete/{id}", method = RequestMethod.GET)
    public String deleteMembers(@PathVariable("id") Integer id) {
        gymModel members=MemberInformationService.getMember(id);
        MemberInformationService.deleteMember(members);
        return "redirect:/index/";
    }
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String indet(Model model) {
        model.addAttribute("gymModel", new gymModel());
        return "add";
    }
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public @ResponseBody String addMember(HttpServletRequest request, @ModelAttribute("gymModel") gymModel members, BindingResult result) {


        gymModel member = new gymModel();
        member.setId(members.getId());
        member.setAdi(members.getAdi());
        member.setSoyadi(members.getSoyadi());
        member.setTelefon(members.getTelefon());

        System.out.println(members.getId());
        System.out.println(members.getAdi());
        System.out.println(members.getSoyadi());
        System.out.println(members.getTelefon());
        MemberInformationService.save(member);
        return "success\n" + member.getAdi() + " " + member.getSoyadi();
    }
}
