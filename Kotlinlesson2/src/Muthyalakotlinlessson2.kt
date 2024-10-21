// Sathvika Muthyala
import java.util.Random

// Function to return a random day of the week
fun randomDay(): String {
    val week = arrayOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")
    return week[Random().nextInt(week.size)]
}

// Function to simulate swimming with a default speed
fun swim(speed: String = "fast") {
    println("swimming $speed")
}

// Function to determine fish food based on the day
fun fishFood(day: String): String {
    return when (day) {
        "Monday" -> "flakes"
        "Wednesday" -> "redworms"
        "Thursday" -> "granules"
        "Friday" -> "mosquitoes"
        "Sunday" -> "plankton"
        else -> "nothing"
    }
}

// Function to decide if water needs changing
fun shouldChangeWater(day: String, temperature: Int = 22, dirty: Int = 20): Boolean {
    return when {
        temperature > 30 -> true
        dirty > 30 -> true
        day == "Sunday" -> true
        else -> false
    }
}

// Function to feed the fish and check if water needs changing
fun feedTheFish() {
    val day = randomDay()
    val food = fishFood(day)
    println("Today is $day and the fish eat $food")
    println("Change water: ${shouldChangeWater(day)}")
}

// Main function to run the program
fun main() {
    feedTheFish()

    // List of decorations
    val decorations = listOf("rock", "pagoda", "plastic plant", "alligator", "flowerpot")

    // Eager evaluation
    val eager = decorations.filter { it[0] == 'p' }
    println("Eager: $eager")

    // Lazy evaluation
    val filtered = decorations.asSequence().filter { it[0] == 'p' }
    println("Filtered (lazy): $filtered")
    val newList = filtered.toList() // Force evaluation
    println("New list (after evaluation): $newList")

    // Demonstrate lazy mapping
    val lazyMap = decorations.asSequence().map {
        println("Access: $it")
        it
    }
    println("Lazy map: $lazyMap")
    println("-----")
    println("First: ${lazyMap.first()}")
    println("-----")
    println("All: ${lazyMap.toList()}")

    // Another lazy example with filter and map
    val lazyMap2 = decorations.asSequence().filter { it[0] == 'p' }.map {
        println("Access: $it")
        it
    }
    println("-----")
    println("Filtered (lazy with map): ${lazyMap2.toList()}")

    // Flattening a list of lists
    val mySports = listOf("basketball", "fishing", "running")
    val myPlayers = listOf("LeBron James", "Ernest Hemingway", "Usain Bolt")
    val myCities = listOf("Los Angeles", "Chicago", "Jamaica")
    val myList = listOf(mySports, myPlayers, myCities) // List of lists
    println("-----")
    println("Flat: ${myList.flatten()}")

    // Working with a lambda expression for dirty level
    var dirtyLevel = 20
    val waterFilter: (Int) -> Int = { dirty -> dirty / 2 }
    fun updateDirty(dirty: Int, operation: (Int) -> Int): Int {
        return operation(dirty)
    }

    println(waterFilter(dirtyLevel))

    // Using a function reference
    fun increaseDirty(start: Int) = start + 1
    println(updateDirty(15, ::increaseDirty))

    // Updating dirty level using a lambda
    dirtyLevel = updateDirty(dirtyLevel) { it + 23 }
    println(dirtyLevel)
}
