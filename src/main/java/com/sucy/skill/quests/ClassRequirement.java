package com.sucy.skill.quests;

import com.sucy.skill.SkillAPI;
import com.sucy.skill.api.player.PlayerData;
import me.pikamug.quests.module.BukkitCustomRequirement;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.Map;
import java.util.UUID;

public class ClassRequirement extends BukkitCustomRequirement {
    public ClassRequirement() {
        setName("Class Requirement");
        setAuthor("Eniripsa96");
        setItem("CHAINMAIL_HELMET", (short) 0);
        addStringPrompt("Class",
                "The player must be the class or a profess of the class in order to take the quest.",
                0);
    }

    @Override
    public boolean testRequirement(UUID id, Map<String, Object> data) {
        String list[], c = data.get("Class").toString();
        if (c.contains(",")) {
            list = c.split(",");
        } else {
            list = new String[]{c};
        }
        Player     player       = Bukkit.getPlayer(id);
        PlayerData playerSkills = SkillAPI.getPlayerData(player);
        for (String item : list) {
            if (playerSkills.isClass(SkillAPI.getClass(item)))
                return true;
        }
        return false;
    }
}
