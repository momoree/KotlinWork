package works.classAndObject

abstract class AquariumFish: FishAction {
    abstract val color: String
    override fun eat() = println("yum")

    object GoldColor : FishColor {
        override val color = "gold"
    }
}

class PrintingFishAction(val food: String) : FishAction {
    override fun eat() {
        println(food)
    }
}

// シールクラス
sealed class Seal
class SeaLion : Seal()
class Walrus : Seal()

fun matchSeal(seal: Seal): String {
    return when(seal) {
        is Walrus -> "walrus"
        is SeaLion -> "sea lion"
    }
}