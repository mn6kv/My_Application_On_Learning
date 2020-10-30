package com.example.myapplication

import kotlin.Int

class Leopard(name: String, power: Byte, luck: Float, health: Int):
    Animal(name, power, luck, health), Predator {

    override fun hide() {
        print("tssss!")
    }

    override fun sharpAttack(rival: Animal) {
        this.hide()
        this.health += (rival.power * rival.luck * this.luck).toInt()
        this.attack(rival)
    }

    override fun sharpenTeeth() {
        print("shwark! shkhawk!!")
    }

}