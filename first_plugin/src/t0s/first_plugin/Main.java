package t0s.first_plugin;

/**
 * Created by etas on 10/5/16.
 */

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.ChatColor;
import java.util.logging.Level;
import org.bukkit.Bukkit;

public final class Main extends JavaPlugin {


    @Override
    public void onLoad() {
        getLogger().log(Level.WARNING, "FIRST__PLUGIN IS LOADING.");

    }

    @Override
    public void onEnable() {

        getLogger().info("first_plugin has been enabled!");
    }


    @Override
    public void onDisable() {
        getLogger().info("first_plugin has been disabled :[");

    }

    public static void asort(String[] list){

        String temp;
        for(int i=0; i < (list.length-1); i++){
            if((list[i].compareToIgnoreCase(list[i+1])) > 0){

                temp = list[i];
                list[i]=list[i+1];
                list[i+1] = temp;

            }



        }

    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String args[]){

        if(cmd .getName().equalsIgnoreCase("list")){
            Player player1 = (Player) sender;
            Player[] player_list = {};

            String[] list = new String[Bukkit.getOnlinePlayers().size()];
            String print_list = "";
            int i = 0;

            for(Player player: Bukkit.getServer().getOnlinePlayers().toArray(player_list)){
                String player_name = player.getDisplayName();

                    if(Bukkit.getServer().getOnlinePlayers().isEmpty()){
                        player1.sendMessage("Nobodies online!");

                    }else if(player.isOp() == true) {
                        player_name = ChatColor.RED + player_name + ChatColor.WHITE;

                    }


                list[i] = player_name;
                i = i++;

            }

            asort(list);

            for(String x: list){
                print_list = x + " ";
            }

            player1.sendMessage(ChatColor.GOLD + "Online(" + getServer().getOnlinePlayers().size() +"): " + ChatColor.WHITE + print_list);


            return true;
            }

        return false;

    }

}



