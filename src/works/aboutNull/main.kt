package works.aboutNull

fun main() {
//    val favoriteActor = null
//    println(favoriteActor)

//    var favoriteActor: String = "Sandra Oh"
//    // Error message:  Null can not be a value of a non-null type String
//    favoriteActor = null

    // null値許容変数の宣言
    var favoriteActor: String? = "Sandra Oh"
    println(favoriteActor)
    favoriteActor = null
    println(favoriteActor)

    var favoriteActor2: String? = "Sandra Oh"
    // Error message: Only safe (?.) or non-null asserted (!!.) calls are allowed on a nullable receiver of type String?
    // nullの可能性がある場合、lengthなどのプロパティは扱えない
//    println(favoriteActor2.length)

    // セーフコール演算子 (?.)を使用することで、null値許容変数のメソッドやプロパティにアクセスできる
    println(favoriteActor2?.length)

    favoriteActor2 = null
    // プログラムのクラッシュは起きず、nullを返す
    println(favoriteActor2?.length)

    // 非nullアサーション演算子（!!）を使用
    // nullでないことの証明
    var favoriteActor3: String? = "Sandra Oh"
    println(favoriteActor3!!.length)

    // NPEの発生
//    favoriteActor3 = null
//    println(favoriteActor3!!.length)

    // if/else 条件構文を使用する
    // if分岐を使用してnullチェックを行うことができる
    var favoriteActor4: String? = "Sandra Oh"
    favoriteActor4 = null
    if (favoriteActor4 != null) {
        println("The number of characters in your favorite actor's name is ${favoriteActor4.length}.")
    } else {
        println("You didn't input a name.")
    }

    val lengthOfName = if(favoriteActor != null) {
        favoriteActor.length
    } else {
        0
    }
    println("The number of characters in your favorite actor's name is $lengthOfName.")

    // エルビス演算子（?:）を使用する
    // セーフコール演算子（?.）と合わせて使用できる演算子
    // セーフコール演算子がnullを返す時のデフォルト値を追加することができる
    var favoriteActor5: String? = "Sandra Oh"
    favoriteActor5 = null

    val lengthOfName2 = favoriteActor5?.length ?: 0
    println("The number of characters in your favorite actor's name is $lengthOfName2.")
}