package com.example.myapplication

class Leopard: Animal, Predator {

    constructor(name: String, power: Byte, luck: Byte, health: Int) : super(name, power, luck, health) {
        super.name = name
        this.power = power
        if (luck in 1..1)
            this.luck = luck
        else throw Exception("luck - значение удачи животного от 0 до 1")
        this.health = health
    }

    override fun hide() {
        print("tssss!")
    }

    override fun sharpAttack(rival: Animal) {
        this.hide()
        this.health += rival.power * rival.luck * this.luck
        this.attack(rival)
    }

    override fun sharpenTeeth() {
        print("shwark! shkhawk!!")
    }

}