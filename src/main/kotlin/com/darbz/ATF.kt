package com.darbz

import net.fabricmc.api.ModInitializer
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayConnectionEvents
import net.minecraft.client.MinecraftClient
import net.minecraft.client.network.ClientPlayNetworkHandler


object ATF : ModInitializer {
	val client = MinecraftClient.getInstance().networkHandler


	var Enabled = false
	override fun onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.


		ATF.info("-------------------------------\n=                             =" +
				"\n=     ANTI FREECAM LOADED     =\n=                             =\n-------------------------------")

		ClientPlayConnectionEvents.DISCONNECT.register(ClientPlayConnectionEvents.Disconnect { handler: ClientPlayNetworkHandler?, client: MinecraftClient? ->
			println("Disconnected from server!")
			Enabled = false
		})

		ClientTickEvents.END_CLIENT_TICK.register(ClientTickEvents.EndTick { client: MinecraftClient? ->
			val player = client?.player ?: return@EndTick
			if (player.isDead) {
				player.requestRespawn()
			}
		})






	}

	fun info(string: String) {
		println(string)
	}


	fun sendChatCommand(s: String) {
        client!!.sendChatCommand(s)

	}

	fun sendChatMessage(s: String) {
		client!!.sendChatMessage(s)
	}


}