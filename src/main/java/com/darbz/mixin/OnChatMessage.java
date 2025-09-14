package com.darbz.mixin;



import com.darbz.data.HandleData;
import net.minecraft.client.network.message.MessageHandler;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MessageHandler.class)
public class OnChatMessage {
    @Inject(method = "onGameMessage(Lnet/minecraft/text/Text;Z)V", at = @At("HEAD"), cancellable = true)
    public void onGameMessage(Text message, boolean overlay, CallbackInfo info)
    {
        String content = message.getString();
        if (content.length() < 7)
            return;

        if (content.substring(0, 6).equals("atf_02"))
        {

            HandleData.parseData(content);
            info.cancel();
        }
    }

}
