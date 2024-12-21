// 1. Coin or Dice Roll Simulator
interface RollingTool {
    fun roll(): String
}

class Coin : RollingTool {
    override fun roll(): String {
        return if ((1..2).random() == 1) "Orzeł" else "Reszka"
    }
}

class Dice : RollingTool {
    override fun roll(): String {
        return (1..6).random().toString()
    }
}

fun mainRollSimulator() {
    println("Wpisz: 1 aby rzucić monetą lub 2 aby rzucić kostką.")
    when (readln().toInt()) {
        1 -> println("Wyrzucono: ${Coin().roll()}")
        2 -> println("Wyrzucono: ${Dice().roll()}")
        else -> println("Niepoprawy wybór")
    }
}

// 2. Random Quote Generator
class Quotes private constructor() {
    private val quotes = mutableListOf("Kłamstwo powtarzane tysiąc razy staje się prawdą. - Joseph Goebells",
        "Głową muru nie przebijesz ale jeśli zawiodły inne metody należy spróbować i tej metody - Józef Piłsudski",
        "Tylko krew, pot i łzy - Winston Churchill",
        "Kim jest papież?, a ile on ma dywizji? - Józef Stalin",
        "Jedna śmierć to tragedia, milion to statystyka - Józef Stalin")

    fun getRandomQuote(): String {
        return quotes.random()
    }

    fun addQuote(quote: String) {
        quotes.add(quote)
    }

    fun getAllQuotes(): List<String> {
        return quotes
    }

    companion object {
        val instance: Quotes by lazy { Quotes() }
    }
}

fun mainQuoteGenerator() {
    val quotesManager = Quotes.instance
    while (true) {
        println("Wybierz: 1 aby wyświetlić losowy cytat, 2 aby dodać cytat do bazy, 3 aby zamknąć program")
        when (readln().toInt()) {
            1 -> println("Wylosowany cytat: ${quotesManager.getRandomQuote()}")
            2 -> {
                println("Wpisz cytat do dodania:")
                val newQuote = readln()
                quotesManager.addQuote(newQuote)
                println("Cytat dodany!")
            }
            3 -> break
            else -> println("Nieprawidłowy wybór!!")
        }
    }
}


fun main(){
    mainQuoteGenerator()
}