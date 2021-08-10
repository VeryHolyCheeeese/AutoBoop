package autoboop;

import net.minecraft.client.Minecraft;
import net.minecraft.init.Blocks;
import net.minecraft.util.StringUtils;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod(modid = AutoBoop.MODID, version = AutoBoop.VERSION)
public class AutoBoop
{
    public static final String MODID = "AutoBoop";
    public static final String VERSION = "1.1";

    @SubscribeEvent
    public void onChat(ClientChatReceivedEvent event) {
      String message = StringUtils.stripControlCodes(event.message.getUnformattedText());
      if (!message.contains(":") && message.contains("Friend > ") && message.contains("joined.") && !(message.contains("Moulberry") || message.contains("DeDiamondPro"))) {
        String player = message.substring(message.indexOf(">") + 2, message.lastIndexOf(" "));
        Minecraft.getMinecraft().thePlayer.sendChatMessage("/boop " + player);
      }
    }
    @EventHandler
    public void init1(FMLInitializationEvent event) {
      MinecraftForge.EVENT_BUS.register(this);
    }
}