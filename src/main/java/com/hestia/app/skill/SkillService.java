package com.hestia.app.skill;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillService {
    private final SkillRepository skillRepository;

    @Autowired
    public SkillService(SkillRepository skillRepository) {
        this.skillRepository = skillRepository;
    }

    public List<Skill> getSkills() {
        return skillRepository.findAll();
    }

    public void addSkills(Skill skill) {
        skillRepository.save(skill);
    }

   public void deleteSkill(Long skillId) {
        if (!skillRepository.existsById(skillId)) {
            throw new IllegalStateException("Skill with id " + skillId + "does not exist");
        } else {
            skillRepository.deleteById(skillId);
        }
    }
}
