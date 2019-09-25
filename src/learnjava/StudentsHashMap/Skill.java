package learnjava.StudentsHashMap;


public class Skill {
    public String skillName;

    public Skill(String skillName){
        this.skillName = skillName;
    }

    @Override
    public String toString() {
        return "Skill = " + skillName;
    }
}
