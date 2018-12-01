package io.github.xshoji.janken

import io.github.xshoji.janken.enums.Gender
import io.github.xshoji.janken.enums.Hand
import io.github.xshoji.janken.service.JankenMachineService
import io.github.xshoji.janken.util.JankenUtility

fun main(args:Array<String>) {

    if (args.size != 4) {
        println("java -jar xxx.jar <name> <gender> <hand> <age>")
        System.exit(0)
    }

    var name = args[0]
    var gender = Gender.valueOf(args[1])
    var hand = Hand.valueOf(args[2])
    var age = Integer.valueOf(args[3])
    if (gender == null) {
        println("java -jar xxx.jar <name> <gender>[Male or Female] <hand> <age>")
        System.exit(0)
    }
    if (gender == null) {
        println("java -jar xxx.jar <name> <gender> <hand>[Gu or Choki or Pa] <age>")
        System.exit(0)
    }

    // Playerを生成する
    var user = JankenUtility.createUser(name, gender, hand, age)
    // Npcを生成する
    var npc = JankenUtility.createNpc()
    // じゃんけんマシーンを生成して実行する
    var jankenMachine = JankenMachineService(user, npc)
    jankenMachine.run()
}
