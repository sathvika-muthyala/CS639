package example.myapp

interface FishAction {
    fun eat()
}

interface FishColor {
    val color: String
}

object GoldColor : FishColor {
    override val color = "gold"
}

class PrintingFishAction(val food: String) : FishAction {
    override fun eat() {
        println(food)
    }
}

class Plecostomus(fishColor: FishColor = GoldColor) : FishAction by PrintingFishAction("eat algae"),
    FishColor by fishColor

class Shark : FishAction, FishColor {
    override val color = "grey"
    override fun eat() {
        println("hunt and eat fish")
    }
}

data class Decoration(val rocks: String, val wood: String, val diver: String)

enum class Color(val rgb: Int) {
    RED(0xFF0000), GREEN(0x00FF00), BLUE(0x0000FF)
}

enum class Direction(val degrees: Int) {
    NORTH(0), SOUTH(180), EAST(90), WEST(270)
}

fun main() {
    val pleco = Plecostomus()
    println("Plecostomus color: ${pleco.color}")
    pleco.eat()

    val shark = Shark()
    println("Shark color: ${shark.color}")
    shark.eat()

    val decoration1 = Decoration("granite", "oak", "fish diver")
    val decoration2 = Decoration("slate", "pine", "mermaid")
    val decoration3 = Decoration("slate", "maple", "seahorse")

    println(decoration1)
    println(decoration2)
    println(decoration3)
    println(decoration1 == decoration2)
    println(decoration3 == decoration2)

    val (rock, wood, diver) = decoration1
    println("Rock: $rock, Wood: $wood, Diver: $diver")

    println(Direction.EAST.name)
    println(Direction.EAST.ordinal)
    println(Direction.EAST.degrees)

    println(Color.RED.rgb)
}
