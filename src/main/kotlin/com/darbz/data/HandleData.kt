package com.darbz.data

import com.darbz.ATF
import net.minecraft.client.MinecraftClient
import net.minecraft.client.gui.DrawContext
import net.minecraft.client.gui.screen.Screen
import net.minecraft.text.Text
import net.minecraft.world.GameMode


class HandleData {

    companion object {
        val client = MinecraftClient.getInstance()

        @JvmStatic
        fun parseData(s: String) {
            val data = s.split("_")
            val mode = Integer.parseInt(data[1])

            when (mode) {
                0 -> {
                    ATF.Enabled = true
                    ATF.sendChatCommand("verify_mod")
                    return
                }

                1 -> {
                    if (client.getCameraEntity() != client.player && client.interactionManager != null &&
                        client.interactionManager!!.getCurrentGameMode() != GameMode.SPECTATOR
                    ) {
                        client.cameraEntity = client.player
                        return
                    }

                }
            }
        }
    }
}

