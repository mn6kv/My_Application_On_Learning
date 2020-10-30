package com.example.myapplication

import kotlin.Int

// power - значение силы животного от 1 до 128
// luck - значение удачи животного от 0 до 1
// health - значение здоровья животного от 1 до 128

open class Animal {

    var name: String
    var power: Byte
    var luck: Float
    protected var health: Int

    constructor(name: String, power: Byte, luck: Float, health: Int) {
        this.name = name
        this.power = power
        if (luck in 1..1)
            this.luck = luck
        else throw Exception("luck - значение удачи животного от 0 до 1")
        this.health = health
    }

    fun isAlive(): Boolean {
        return this.health > 0
    }

    fun attack(rival: Animal): String {
        rival.health -= (this.power * this.luck).toInt()
        if (rival.isAlive())
            this.health -= (rival.power * rival.luck * this.luck).toInt()
        return this.name + "attacked" + rival.name + "\n" + this.name + "'s health: " + this.health +
                rival.name + "'s health: " + rival.health
    }

}
