package frage.main;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import frage.frage.ujacmd;
import frage.frage.uneincmd;
import frage.frage.umfragecmd;

public class main extends JavaPlugin implements Listener {
  public static String prefix = "Umfrage > ";
  public static String noperms = prefix + "Dazu hast du keine Rechte";

  Integer counter;
  int time = 301;
  
  public void onEnable() {
	  Bukkit.getConsoleSender().sendMessage(" ");
	  Bukkit.getConsoleSender().sendMessage("§8>> §6Enders Votekick §8| §6Status§8: §aaktiviert§8!");
	  Bukkit.getConsoleSender().sendMessage(" ");
    
    init(Bukkit.getPluginManager());

  }
  
  public void init(PluginManager pm) {
	  
	  getCommand("uja").setExecutor((CommandExecutor)new ujacmd());
	  getCommand("unein").setExecutor((CommandExecutor)new uneincmd());
	  getCommand("umfrage").setExecutor((CommandExecutor)new umfragecmd());
	  
  }

  
  public void onDisable() {
	  Bukkit.getConsoleSender().sendMessage(" ");
	  Bukkit.getConsoleSender().sendMessage("§8>> §6Enders Votekick §8| §6Status§8: §cdeaktiviert§8!");
	  Bukkit.getConsoleSender().sendMessage(" ");
  }
  
  public static Plugin getInstance() {
	     return (Plugin)getPlugin(main.class);
	   }

}