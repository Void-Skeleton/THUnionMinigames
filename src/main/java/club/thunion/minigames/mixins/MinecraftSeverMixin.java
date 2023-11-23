package club.thunion.minigames.mixins;

import club.thunion.minigames.miniminigames.WalkingOnIceGameLogic;
import club.thunion.minigames.miniminigames.WalkingOnIceGameEntities;
import net.minecraft.server.MinecraftServer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MinecraftServer.class)
public class MinecraftSeverMixin {
    WalkingOnIceGameLogic startCheck = new WalkingOnIceGameLogic();

    @Inject(at = @At("HEAD"), method = "tick")
    private void init(CallbackInfo info) {
        if (WalkingOnIceGameEntities.isEnabled == true) {
            startCheck.startCheck(WalkingOnIceGameEntities.player);
        }
    }
}
