package com.darbz

import net.fabricmc.api.ModInitializer
import net.minecraft.client.MinecraftClient


object ATF : ModInitializer {
	val client = MinecraftClient.getInstance().networkHandler

	override fun onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		info("Hello Fabric world!")
	}

	fun info(string: String) {
		println(string)
	}


	private fun sendCommand(s: String) {

        client?.sendChatCommand(s)

	}

	private fun sendChatMessage(s: String) {
		client?.sendChatMessage(s)
	}


}