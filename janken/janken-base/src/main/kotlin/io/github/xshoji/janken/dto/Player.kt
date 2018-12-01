package io.github.xshoji.janken.dto

import io.github.xshoji.janken.enums.Gender
import io.github.xshoji.janken.enums.Hand

class Player(name: String, var gender: Gender, var hand: Hand, var age: Int) {
    var name: String = name
      get() = if (gender == Gender.Male) field + "くん" else  field + "ちゃん"
}