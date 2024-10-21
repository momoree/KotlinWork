package works.function


fun main() {
    val decorations = listOf("rock", "pagoda", "plastic plant", "alligator", "flowerpot")
    println(decorations.filter { it[0] == 'p' })

    // 全て処理
    val eager = decorations.filter { it[0] == 'p' }
    println("eager: $eager")

    // 必要なものだけを処理するためのメソッド = asSequence
    // この時点では情報が足りない
    val filtered = decorations.asSequence().filter { it[0] == 'p' }
    println("filtered: $filtered")

    // ここで初めて、何をするかを指定
    val newList = filtered.toList()
    println("new list: $newList")

    val lazyMap = decorations.asSequence().map {
        println("access: $it")
        it
    }
    // 呼ぶだけではうまくいかない
    println("lazy: $lazyMap")
    println("-----")
    // 最初の値を取得
    println("first: ${lazyMap.first()}")
    println("-----")
    // 全ての値を取得
    println("all: ${lazyMap.toList()}")

    // filterと一文でまとめることが可能
    val lazyMap2 = decorations.asSequence().filter { it[0] == 'p' }.map {
        println("access: $it")
        it
    }
    println("-----")
    println("filtered: ${lazyMap2.toList()}")

    /*
    上記の処理のように必要な値だけを処理するため、普通のリストを使用するよりasSequenceを使用することで処理速度の上昇が期待される
     */
}