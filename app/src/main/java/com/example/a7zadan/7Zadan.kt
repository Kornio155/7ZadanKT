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

// 3. Favorite Books Tracker
data class Book(val title: String, val author: String, val year: Int)

class BookTracker {
    private val books = mutableListOf<Book>()

    fun addBook(book: Book) {
        books.add(book)
    }

    fun filterByAuthor(author: String): List<Book> {
        return books.filter { it.author.equals(author, ignoreCase = true) }
    }

    fun filterByYear(year: Int): List<Book> {
        return books.filter { it.year == year }
    }

    fun sortByTitle(): List<Book> {
        return books.sortedBy { it.title }
    }

    fun getAllBooks(): List<Book> {
        return books
    }
}

fun mainBookTracker() {
    val tracker = BookTracker()
    tracker.addBook(Book("Wiedźmin. Rozdroże kruków", "Andrzej Sapkowski", 2024))
    tracker.addBook(Book("Oszpicyn", "Krzysztof Zajas", 2017))
    tracker.addBook(Book("Star Wars. Koniec i początek", "Chuck Wendig", 2015))
    tracker.addBook(Book("www.1939.com.pl", "Marcin Ciszewski", 2023))
    tracker.addBook(Book("Morderstwo w Orient Expressie", "Agata Christie", 2010))

    println("Wybierz: 1 aby dodać książkę, 2 aby filtrować według autora, 3 aby filtrować według roku, 4 aby sortować według tytułu, 5 aby wyświetlić listę wszystkich książek")
    when (readln().toInt()) {
        1 -> {
            println("Wpisz tytuł, autora i rok wydania:")
            val (title, author, year) = readln().split(", ")
            tracker.addBook(Book(title, author, year.toInt()))
            println("Książka dodana!")
        }
        2 -> {
            println("Podaj autora:")
            val author = readln()
            println("Kiążki napisane przez $author: ${tracker.filterByAuthor(author)}")
        }
        3 -> {
            println("Podaj rok")
            val year = readln().toInt()
            println("Książki z roku $year: ${tracker.filterByYear(year)}")
        }
        4 -> println("Książki posortowane alfabetycznie: ${tracker.sortByTitle()}")
        5 -> println("Wszytskie książki: ${tracker.getAllBooks()}")
        else -> println("Niepoprawny wybór")
    }
}

fun main(){
    mainBookTracker()
}