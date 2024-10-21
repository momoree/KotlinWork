package works.classAndObject

import java.lang.Math.PI

// クラスにコンストラクタを追加
// コンストラクタにプロパティを直接定義することで、コンパクトなコンストラクタが生成可能
// open = オーバーライドできるようにする
open class Aquarium(var length: Int = 100, var width: Int = 20, open var height: Int = 40) {
    open var volume: Int
        // ゲッター
        get() = width * height * length / 1000  // 1000 cm^3 = 1 l
        // セッター
        set(value) {
            height = (value * 1000) / (width * length)
        }

    open val shape = "rectangle"
    open var water: Double = 0.0
        get() = volume * 0.9

    // 初期化コード
    init {
        println("aquarium initializing")
    }
    // いくつか追加することが可能
    // initブロックはクラス定義に出現する順序で実行され、コンストラクターが呼び出されるとすべてが実行される
//    init {
//        // 1 liter = 1000 cm^3
//        println("Volume: ${width * length * height / 1000} l")
//    }

    // セカンダリコンストラクタ
    // initが実行された後に実行
    constructor(numberOfFish: Int) : this() {
        // 2,000 cm^3 per fish + extra room so water doesn't spill
        val tank = numberOfFish * 2000 * 1.1
        // calculate the height needed
        height = (tank / (length * width)).toInt()
    }

    fun printSize() {
        println(shape)
        println(
            "Width: $width cm " +
                    "Length: $length cm " +
                    "Height: $height cm "
        )

        // 1 l = 1000 cm^3
        println("Volume: $volume l")
    }

    // サブクラス
    class TowerTank(override var height: Int, var diameter: Int) :
        Aquarium(height = height, width = diameter, length = diameter) {
        override var volume: Int
            // ellipse area = π * r1 * r2
            get() = (width / 2 * length / 2 * height / 1000 * PI).toInt()
            set(value) {
                height = ((value * 1000 / PI) / (width / 2 * length / 2)).toInt()
            }

        override var water = volume * 0.8
        override val shape = "cylinder"
    }

    class Shark: AquariumFish(), FishAction {
        override val color = "gray"
        override fun eat() {
            println("hunt and eat fish")
        }
    }

    class Plecostomus: AquariumFish(), FishAction {
        override val color = "gold"
        override fun eat() {
            println("eat algae")
        }
    }
}