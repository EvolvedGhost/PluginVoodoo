package org.AlerHughes.Command

import net.mamoe.mirai.console.command.CommandSender
import net.mamoe.mirai.console.command.SimpleCommand
import net.mamoe.mirai.message.data.PlainText
import net.mamoe.mirai.message.data.At
import net.mamoe.mirai.message.data.buildMessageChain
import org.AlerHughes.*
import org.AlerHughes.Model.Tarot


object TarotCommand : SimpleCommand(
    PluginVoodoo, "vdTarot",
    description = "塔罗牌占卜"
) {
    @Handler
    suspend fun CommandSender.handle() {
        val tarot: Tarot = GetRandomTarot()
        val info: String = GetInfoByTarot(tarot)
        val imgFile = getTarotImg(tarot, user!!)
        sendMessage(buildMessageChain {
            +At(user!!)
            +PlainText("\n${info}\n")
            +imgFile
        })
    }
}