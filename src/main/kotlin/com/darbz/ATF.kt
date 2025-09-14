package com.darbz

import net.fabricmc.api.ModInitializer
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayConnectionEvents
import net.minecraft.client.MinecraftClient

object ATF : ModInitializer {
	var Enabled = false

	override fun onInitialize() {
		info("-------------------------------\n=                             =" +
				"\n=     ANTI FREECAM LOADED     =\n=                             =\n-------------------------------")

		// Reset on disconnect
		ClientPlayConnectionEvents.DISCONNECT.register { _, _ ->
			println("Disconnected from server!")
			Enabled = false
		}

		// Respawn automatically on death
		ClientTickEvents.END_CLIENT_TICK.register { client ->
			val player = client?.player ?: return@register
			if (player.isDead) {
				player.requestRespawn()
			}

		}
	}

	fun info(string: String) {
		println(string)
	}

	fun sendChatCommand(command: String) {
		val client = MinecraftClient.getInstance()
		val networkHandler = client.networkHandler ?: return
		client.execute {
			networkHandler.sendChatCommand(command)
		}
	}

	fun sendChatMessage(message: String) {
		val client = MinecraftClient.getInstance()
		val player = client.player ?: return
		client.execute {
			client.networkHandler?.sendChatMessage(message)
		}
	}
}
