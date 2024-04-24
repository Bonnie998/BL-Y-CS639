package example.myapp

fun buildAquarium() {
    val myAquarium = Aquarium(width = 25, length = 25, height = 40)
    myAquarium.printSize()
    val myTower = Aquarium.TowerTank(diameter = 25, height = 40)
    myTower.printSize()
    myAquarium.printSize()
    myAquarium.height = 60
    myAquarium.printSize()
    val aquarium1 = Aquarium()
    aquarium1.printSize()
    // default height and length
    val aquarium2 = Aquarium(width = 25)
    aquarium2.printSize()
    // default width
    val aquarium3 = Aquarium(height = 35, length = 110)
    aquarium3.printSize()
    // everything custom
    val aquarium4 = Aquarium(width = 25, height = 35, length = 110)
    aquarium4.printSize()
    val aquarium6 = Aquarium(length = 25, width = 25, height = 40)
    aquarium6.printSize()
}

fun makeFish() {
    val shark = AquariumFish.Shark()
    val pleco = AquariumFish.Plecostomus()

    println("Shark: ${shark.color}")
    shark.eat()
    println("Plecostomus: ${pleco.color}")
    pleco.eat()
}
class AquariumFish {
    interface FishAction {
        fun eat()
    }

    interface FishColor {
        val color: String
    }

    class Shark : FishAction, FishColor {
        override val color = "grey"
        override fun eat() {
            println("eat other fish")
        }
    }

    class Plecostomus(fishColor: GoldColor = GoldColor) : FishAction, FishColor by fishColor {
        override fun eat() {
            println("eat algae")
        }
    }
}

fun main () {
    makeFish()
}