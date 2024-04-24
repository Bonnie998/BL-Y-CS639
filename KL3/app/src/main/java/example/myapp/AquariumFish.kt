package example.myapp

interface FishAction {
    fun eat()
}

interface FishColor {
    val color: String
}
object GoldColor : FishColor, AquariumFish.FishColor {
    override val color = "gold"
}

class Plecostomus (fishColor: FishColor = GoldColor):
    FishAction by PrintingFishAction("eat algae"),
    FishColor by fishColor

class PrintingFishAction(val food: String) : FishAction {
    override fun eat() {
        println(food)
    }

    class PrintingFishAction(val food: String) : FishAction {
        override fun eat() {
            println(food)
        }
    }

}