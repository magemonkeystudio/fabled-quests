package com.promcteam.fabled.quests;

import com.promcteam.fabled.Fabled;
import com.promcteam.fabled.api.player.PlayerData;
import me.pikamug.quests.module.BukkitCustomReward;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.Map;
import java.util.UUID;

public class ClassAttributeReward extends BukkitCustomReward {
    private static final String NAME = "Class Attribute Points Reward";

    private static final String AUTHOR = "ProMCTeam";

    private static final String REWARD_NAME = "Attribute Points";

    private static final String POINTS = "Points";

    public ClassAttributeReward() {
        setName("Class Attribute Points Reward");
        setAuthor("ProMCTeam");
        setDisplay("Attribute Points");
        setItem("FEATHER", (short) 0);
        addStringPrompt("Points", "Enter how many attribute points to give to the player", 0);
    }

    @Override
    public void giveReward(UUID id, Map<String, Object> data) {
        try {
            int        points       = Integer.parseInt(data.get("Points").toString());
            Player     player       = Bukkit.getPlayer(id);
            PlayerData playerSkills = Fabled.getPlayerData(player);
            playerSkills.giveAttribPoints(points);
        } catch (Exception ex) {
        }
    }
}