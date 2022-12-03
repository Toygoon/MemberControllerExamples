package chap6.ex1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/ex1")
public class MemberController {
    @Autowired
    private MemberDAO dao;

    @RequestMapping("/list")
    public String memberListPage(Model model) {
        model.addAttribute("members", dao.listMembers());

        return "ex1/listMembers";
    }

    @RequestMapping("/addForm")
    public String addForm() {
        return "ex1/addForm";
    }

    @RequestMapping("/add")
    public String addNewMember(Model model, MemberVO member) {
        dao.addMember(member);

        return "redirect:list";
    }

    @RequestMapping("/list/{memberId}")
    public String memberUpdatePage(@PathVariable Integer memberId, Model model) {
        model.addAttribute("member", dao.getMember(memberId));

        return "ex1/updateForm";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateMember(Model model, MemberVO member) {
        dao.updateMember(member);

        return "redirect:list";
    }

    @RequestMapping(value = "/delete/{memberId}", method = RequestMethod.POST)
    public String deleteMember(@PathVariable Integer memberId, Model model) {
        dao.deleteMember(memberId);

        return "redirect:/ex1/list";
    }

}
