package io.github.xshoji.janken.service

import io.github.xshoji.janken.dto.Player
import io.github.xshoji.janken.enums.Hand

class JankenMachineService(var user: Player, var npc: Player) {
    fun run() {
        println("== [ user info ] =======")
        println("user name : ${user.name}")
        println("user age : ${user.age}")
        println("user hand : ${user.hand}")
        println("")
        println("== [ npc info ] =======")
        println("npc name : ${npc.name}")
        println("npc age : ${npc.age}")
        println("npc hand : ${npc.hand}")
        println("")
        println("== [ janken result ] =======")
        if (user.hand == npc.hand) {
            println("あいこ")
        } else if (user.hand == Hand.Gu && npc.hand == Hand.Pa) {
            println("${user.name}の負け！")
        } else if (user.hand == Hand.Gu && npc.hand == Hand.Choki) {
            println("${user.name}の勝ち！")
        } else if (user.hand == Hand.Pa && npc.hand == Hand.Choki) {
            println("${user.name}の負け！")
        } else if (user.hand == Hand.Pa && npc.hand == Hand.Gu) {
            println("${user.name}の勝ち！")
        } else if (user.hand == Hand.Choki && npc.hand == Hand.Gu) {
            println("${user.name}の負け！")
        } else if (user.hand == Hand.Choki && npc.hand == Hand.Pa) {
            println("${user.name}の勝ち！")
        } else {

        }
    }
}