package io.github.xshoji.janken

import io.github.xshoji.janken.enums.Gender
import io.github.xshoji.janken.enums.Hand
import io.github.xshoji.janken.service.JankenMachineService
import io.github.xshoji.janken.util.JankenUtility
import org.apache.commons.lang3.EnumUtils
import java.util.stream.Collectors

fun main(args:Array<String>) {

    if (args.size != 4) {
        println("java -jar xxx.jar <name> <gender> <hand> <age>")
        System.exit(0)
    }

    var name = args[0]
    if (!EnumUtils.isValidEnum(Gender::class.java, args[1])) {
        println("java -jar xxx.jar <name> <gender> <hand> <age>")
        println("<gender>: " + Gender.values().toList().stream().map{e -> e.name}.collect(Collectors.toList()))
        System.exit(0)
    }
    var gender = Gender.valueOf(args[1])
    if (!EnumUtils.isValidEnum(Hand::class.java, args[2])) {
        println("java -jar xxx.jar <name> <gender> <hand> <age>")
        println("<hand>: " + Hand.values().toList().stream().map{e -> e.name}.collect(Collectors.toList()))
        System.exit(0)
    }
    var hand = Hand.valueOf(args[2])
    var age = Integer.valueOf(args[3])

    // Playerを生成する
    var user = JankenUtility.createUser(name, gender, hand, age)
    // Npcを生成する
    var npc = JankenUtility.createNpc()
    // じゃんけんマシーンを生成して実行する
    var jankenMachine = JankenMachineService(user, npc)
    jankenMachine.run()
}
