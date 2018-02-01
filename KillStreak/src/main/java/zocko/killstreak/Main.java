package zocko.killstreak;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import zocko.killstreak.listener.DeathListener;

import java.util.HashMap;

/**
 * Class created on 01.02.2018
 */
public class Main extends JavaPlugin {

    private String prefix = "§7[§cKillStreak§7]";

    public HashMap<Player, Integer> killstreaks = new HashMap<>();

    private static Main instance;

    @Override
    public void onEnable() {
        instance = this;

        Bukkit.getPluginManager().registerEvents(new DeathListener(), this);
    }

    public void addKill(Player player) {
        int kills = killstreaks.get(player);
        kills++;

        killstreaks.remove(player);
        killstreaks.put(player, kills);

        switch (kills) {
            case 5:
                Bukkit.broadcastMessage(prefix + "§6" + player.getName() + " §ahat eine Killstreak von 5 erreicht!");
                break;

            case 10:
                Bukkit.broadcastMessage(prefix + "§6" + player.getName() + " §ahat eine Killstreak von 10 erreicht!");
                break;
        }
    }

    public void clearKill(Player player) {
        killstreaks.remove(player);
    }

    public static Main getInstance() {
        return instance;
    }
}
