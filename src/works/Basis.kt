package works

import java.util.Arrays.toString

fun main() {

    // 型の使い方
    useTheMold()
    // if, whenの使い方
    compareConditionsAndBooleans()
    // null許容
    nullability()
    // list
    list()
    // array
    array()
    // loop
    loop()
}

fun useTheMold() {

    val i: Int = 6
    val b1 = i.toByte()
    println(b1)

    val b2: Byte = 1
    println(b2)

    // 型変換（キャスト）する
    val i1: Int = b2.toInt()
    println(i1)
    val i2: String = b2.toString()
    println(i2)
    val i3: Double = b2.toDouble()
    println(i3)

    // 長い数値定数を読みやすくするために、Kotlinでは意味のある場所に数値にアンダースコアを配置できる
    val oneMillion = 1_000_000
    println(oneMillion)
    val socialsecurityNumber = 999_99_9999L
    println(socialsecurityNumber)
    val hexBytes = 0xFF_EC_DE_5E
    println(hexBytes)
    val bytes = 0b11010010_01101001_10010100_10010010
    println(bytes)


    var fish1 = 1
    fish1 = 2
    val aquarium = 1
//    aquarium = 2 ⇦再代入によるエラー

    var fish2: Int = 12
    var lakes: Double = 2.5

    val numberOfFish = 5
    val numberOfPlants = 12

    println("I have $numberOfFish fish and $numberOfPlants plants")
    println("I have ${numberOfFish + numberOfPlants} fish and plants")
}

fun compareConditionsAndBooleans() {

    val numberOfFish = 50
    val numberOfPlants = 23
    if (numberOfFish > numberOfPlants) {
        println("Good ratio!")
    } else {
        println("Unhealthy ratio")
    }

    val fish = 50
    if (fish in 1..100) {
        println(fish)
    }

    if (numberOfFish == 0) {
        println("Empty tank")
    } else if (numberOfFish < 40) {
        println("Got fish!")
    } else {
        println("That's a lot of fish!")
    }

    when (numberOfFish) {
        0 -> println("Empty tank")
        in 1..39 -> println("Got fish!")
        else -> println("That's a lot of fish!")
    }
}

fun nullability() {

//    var rocks: Int = null
    // ⇒ error: null can not be a value of a non-null type Int

    var marbles: Int? = null

    var fishFoodTreats: Int? = 6
    if (fishFoodTreats != null) {
        fishFoodTreats = fishFoodTreats.dec()
    }
    // これが↓のようにかける
    fishFoodTreats = fishFoodTreats?.dec()

    fishFoodTreats = fishFoodTreats?.dec() ?: 0

    val s: String = "String"
    val len = s!!.length   // throws NullPointerException if s is null
}

fun list() {

    val school = listOf("mackerel", "trout", "halibut")
    // school.remove() // 変更できないので、消せない
    println(school)

    // 変更できるlist
    val myList = mutableListOf("tuna", "salmon", "shark")
    myList.remove("shark")
    println(myList)

}

fun array() {

    val school = arrayOf("shark", "salmon", "minnow")
    println(toString(school))

    // 型の混在が可能
    val mix = arrayOf("fish", 2)
    println(toString(mix))

    // 型を持たせることも可能
    val numbers = intArrayOf(1, 2, 3)
    println(toString(numbers))

    val numbers2 = intArrayOf(4, 5, 6)
    // +演算子により配列の結合
    val foo2 = numbers2 + numbers
    println(toString(foo2))
    println(foo2[5])

    // 配列とリストの混合
    val oceans = listOf("Atlantic", "Pacific")
    val oddList = listOf(numbers, oceans, "salmon")
    println(oddList)

    // コードによる初期化が可能
    val array = Array(5) { it * 2 }
    println(toString(array))
}

fun loop() {

    // for文
    val school = arrayOf("shark", "salmon", "minnow")
    for (element in school) {
        print("$element ")
    }
    println()

    // 要素とインデックスの同時ループ
    for ((index, element) in school.withIndex()) {
        print("Item at $index is $element\n")
    }

    // 範囲指定
    for (i in 1..5) print(i)
    println()
    // 降順ループ
    for (i in 5 downTo 1) print(i)
    println()
    // スキップしながらループ
    for (i in 3..6 step 2) print(i)
    println()
    // アルファベットのループ
    for (i in 'd'..'g') print(i)
    println()

    // while文
    var bubbles = 0
    while (bubbles < 50) {
        bubbles++
    }
    println("$bubbles bubbles in the water")

    // do-while文
    do {
        bubbles--
    } while (bubbles > 50)
    println("$bubbles bubbles in the water")

    // repeat文
    repeat(2) {
        println("A fish is swimming")
    }
}