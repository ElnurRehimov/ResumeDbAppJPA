//import model.Country;
import model.Country;
import model.EmployedHistory;
import model.Skill;
import model.User;
import service.serviceImpl.EmployedHistoryServiceImpl;
import service.serviceImpl.SkillServiceImpl;
import service.serviceImpl.UserServiceImpl;
import service.serviceInter.EmployedHistoryServiceInter;
import service.serviceInter.SkillServiceInter;
import service.serviceInter.UserServiceInter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    private static EmployedHistoryServiceInter employedHistoryService = new EmployedHistoryServiceImpl();
    private static SkillServiceInter skillService = new SkillServiceImpl();
    private static UserServiceInter userService = new UserServiceImpl();

    public static void main(String[] args) {
        insertData();
        List<Skill> skills = skillService.findSkills();
        System.out.println("Skill: " + skills);

        List<User> users = userService.findUsers();
        System.out.println("User: " + users);

        List<EmployedHistory> employedHistories = employedHistoryService.findEmpHistories();
        System.out.println("Emp: " + employedHistories);

    }

    public static void insertData(){
        Country country = new Country("Azerbaijan", "Azerbaijani");
        User user = new User("Farid", "Tahmazov", "tahmazovfarid7@gmail.com",
                "055-977-32-37", "Hii", "Baku", new Date());
        Skill skill = new Skill("Java");

        EmployedHistory employedHistory = new EmployedHistory("Java Software Developer", new Date(),
                new Date(), "Im very ability!");

        user.setCountry(country);
        employedHistory.setUser(user);

        List<Skill> skills = new ArrayList<>();
        skills.add(skill);
        user.setSkills(skills);
        
        skillService.saveSkill(skill);
        userService.saveUser(user);
        employedHistoryService.saveEmpHistory(employedHistory);

    }

}
