package com.darbz.data

import com.darbz.ATF
import net.minecraft.client.MinecraftClient
import net.minecraft.world.GameMode

class HandleData {

    companion object {
        val client = MinecraftClient.getInstance()
        @JvmStatic
        fun parseData(s: String) {
            val data = s.split("#")
            val mode = Integer.parseInt(data[1])

            when (mode) {
                0 -> {
                    ATF.Enabled = true
                    ATF.sendChatCommand("verify_mod")
                }

                1 -> {
                    if (ATF.Enabled && client.interactionManager!!.currentGameMode != GameMode.SPECTATOR) {

                        client.setCameraEntity(client.player)


                    }



                }
            }

    }


    }
}