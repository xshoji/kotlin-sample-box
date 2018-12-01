package io.github.xshoji.janken.util

import io.github.xshoji.janken.dto.Player
import io.github.xshoji.janken.enums.Gender
import io.github.xshoji.janken.enums.Hand
import java.util.*

object JankenUtility {
    fun createUser(name: String, gender: Gender, hand: Hand, age: Int): Player {
        return Player(name, gender, hand, age)
    }

    fun createNpc(): Player {
        return Player("Npc", getGenderRandom(), getHandRandom(), Random().nextInt(99))
    }

    fun getHandRandom(): Hand {
        return when (Random(System.currentTimeMillis()).nextInt(3)) {
          0 -> Hand.Gu
          1 -> Hand.Choki
          else -> Hand.Pa
        }
    }
    fun getGenderRandom(): Gender {
        return when (Random(System.currentTimeMillis()).nextInt(2)) {
            0 -> Gender.Male
            else -> Gender.Female
        }
    }
}
