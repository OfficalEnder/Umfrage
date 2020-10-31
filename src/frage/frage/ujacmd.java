package frage.frage;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import frage.main.main;

public class ujacmd
  implements CommandExecutor
{
  public boolean onCommand(CommandSender cs, Command command, String s, String[] args) {
    if (cs instanceof Player)
    { Player p = (Player)cs;
      if (vote.voting) {
        vote.addJa(p);
        vote.votes.put(p, p.getName());
      } else {
        p.sendMessage(main.prefix + "Es findet derzeit §ckeine §7Umfrage statt§8!");
      }  }
     return false;
  }
}
