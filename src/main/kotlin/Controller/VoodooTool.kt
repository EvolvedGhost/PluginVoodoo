package org.AlerHughes

import kotlinx.serialization.decodeFromString
import net.mamoe.mirai.contact.User
import net.mamoe.mirai.message.data.Image
import net.mamoe.mirai.utils.ExternalResource.Companion.uploadAsImage
import org.AlerHughes.Controller.CustomJson
import org.AlerHughes.Model.Tarot

typealias tarotTable = Map<Int, Tarot>

var tarotsCache: tarotTable = mapOf()

fun InitTarot() {
    tarotsCache = CustomJson.decodeFromString(PluginVoodoo.dataFolder.resolve("TarotData/Tarots.json").readText())
}

fun GetRandomTarot(): Tarot {
    return tarotsCache.values.random()
}

// 获取塔罗牌正逆位文本
fun GetInfoByTarot(tarot: Tarot): String {
    val randomNum = (0..1).random()
    val des: String = if (randomNum == 0)
        "\n#逆位\n#" + tarot.info.reverseDescription
    else
        "\n#正位\n#" + tarot.info.description
    return """
        #${tarot.name} $des
        """.trimMargin("#")
}

suspend fun getTarotImg(tarot: Tarot, user: User): Image {
    return PluginVoodoo.resolveDataFile(tarot.info.imgUrl).uploadAsImage(user)
}
