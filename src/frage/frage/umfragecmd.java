package frage.frage;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import frage.main.main;

public class umfragecmd implements CommandExecutor {
	Integer counter;
	int time = 31;

	public boolean onCommand(CommandSender cs, Command command, String s, String[] args) {
		if (cs instanceof Player) {
			Player p = (Player) cs;
			if (p.hasPermission("frage.frage")) {
				if (args.length >= 1) {
					String reason = "";
					for (int i = 0; i < args.length; i++) {
						reason = reason + args[i] + " ";
					}
					if (!vote.voting) {
						vote.voting = true;
						Bukkit.broadcastMessage(" ");
						Bukkit.broadcastMessage(main.prefix + "Es wurde eine §eUmfrage §7gestartet§8!");
						Bukkit.broadcastMessage(main.prefix + "Frage§8: §e" + reason);
						Bukkit.broadcastMessage(main.prefix + "Stimme ab mit §a/uja §7oder §c/unein§8!");
						Bukkit.broadcastMessage(" ");
						this.counter = Integer.valueOf(
								Bukkit.getScheduler().scheduleSyncRepeatingTask(main.getInstance(), new Runnable() {
									public void run() {
										umfragecmd.this.time--;
										if (umfragecmd.this.time == 20) {
											Bukkit.broadcastMessage(main.prefix + "§7Die §eUmfrage §7endet in §e" + umfragecmd.this.time + " §7Sekunden§8!");
										}

										if (umfragecmd.this.time == 10) {
											Bukkit.broadcastMessage(main.prefix + "§7Die §eUmfrage §7endet in §e" + umfragecmd.this.time + " §7Sekunden§8!");
										}

										if (umfragecmd.this.time == 5) {
											Bukkit.broadcastMessage(main.prefix + "§7Die §eUmfrage §7endet in §e" + umfragecmd.this.time + " §7Sekunden§8!");
										}

										if (umfragecmd.this.time == 4) {
											Bukkit.broadcastMessage(main.prefix + "§7Die §eUmfrage §7endet in §e" + umfragecmd.this.time + " §7Sekunden§8!");
										}

										if (umfragecmd.this.time == 3) {
											Bukkit.broadcastMessage(main.prefix + "§7Die §eUmfrage §7endet in §e" + umfragecmd.this.time + " §7Sekunden§8!");
										}

										if (umfragecmd.this.time == 2) {
											Bukkit.broadcastMessage(main.prefix + "§7Die §eUmfrage §7endet in §e" + umfragecmd.this.time + " §7Sekunden§8!");
										}

										if (umfragecmd.this.time == 1) {
											Bukkit.broadcastMessage(main.prefix + "§7Die §eUmfrage §7endet in §eeiner §7Sekunde§8!");
										}

										if (umfragecmd.this.time == 0) {
											Bukkit.broadcastMessage(main.prefix + "§7Die §eUmfrage §7ist vorbei§8!");
											Bukkit.broadcastMessage(main.prefix + "§7Stimmen fuer §aJa§8: §e" + vote.getJa());
											Bukkit.broadcastMessage(main.prefix + "§7Stimmen fuer §cNein§8: §e" + vote.getNein());
											vote.voting = false;
											vote.votes.clear();
											if (vote.getJa() == vote.getNein()) {
												Bukkit.broadcastMessage(main.prefix + "§c§nUnentschieden§8!");
											}
											vote.ja = 0;
											vote.nein = 0;
										}
									}
								}, 0L, 20L));
					} else {
						p.sendMessage(main.prefix + "§cEs laeuft derzeit eine Umfrage oder ein Votekick!");
					}
				} else {
					p.sendMessage(main.prefix + "§7Benutze §c/umfrage <Frage>");
				}
			} else {
				p.sendMessage(main.noperms);
			}
		}
		return false;
	}
}
