package zocko.killstreak.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import zocko.killstreak.Main;

/**
 * Class created on 01.02.2018
 */
public class DeathListener implements Listener {

    @EventHandler
    public void onDeath(PlayerDeathEvent e) {
        Main.getInstance().addKill(e.getEntity().getKiller());
        Main.getInstance().clearKill(e.getEntity());
    }
}
