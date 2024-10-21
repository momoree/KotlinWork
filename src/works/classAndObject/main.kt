package works.classAndObject

interface FishAction {
    fun eat()
}

class Plecostomus(fishColor: FishColor = AquariumFish.GoldColor):
    FishAction by PrintingFishAction("eat algae"),
    FishColor by fishColor
//    override val color = "gold"

class Shark: FishAction, FishColor {
    override val color = "gray"
    override fun eat() {
        println("hunt and eat fish")
    }
}

interface FishColor {
    val color: String
}


fun buildAquarium() {
    val myAquarium = Aquarium()
    myAquarium.printSize()
    myAquarium.height = 60
    myAquarium.printSize()

    println("---------")

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

    println("---------")

//    val aquarium6 = Aquarium(numberOfFish = 29)
    val aquarium6 = Aquarium(length = 25, width = 25, height = 40)
    aquarium6.printSize()
//    println("Volume: ${aquarium6.width * aquarium6.length * aquarium6.height / 1000} l")
    aquarium6.volume = 70
    aquarium6.printSize()

    println("---------")

    val myAquarium2 = Aquarium(width = 25, length = 25, height = 40)
    myAquarium2.printSize()
    val myTower = Aquarium.TowerTank(diameter = 25, height = 40)
    myTower.printSize()
}

fun makeFish() {
    val shark = Aquarium.Shark()
    val pleco = Aquarium.Plecostomus()

    println("Shark: ${shark.color}")
    shark.eat()
    println("Plecostomus: ${pleco.color}")
    pleco.eat()

}

fun main() {
//    buildAquarium()
//    makeFish()
    makeDecorations()
}