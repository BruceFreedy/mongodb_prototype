import com.mongodb.client.model.Filters
import org.litote.kmongo.*


data class Jedi(val name: String, val age: Int)

fun main() {
    val before = System.currentTimeMillis()
    val client =
        KMongo.createClient("url") //get com.mongodb.MongoClient new instance
    val database = client.getDatabase("test2") //normal java driver usage
    val col = database.getCollection<Jedi>() //KMongo extension method
    col.insertOne(Jedi("Luke Skywalker", 19))
    col.insertOne(Jedi("Baby", 2000))
    col.insertOne(Jedi("Baby", 2000))
    col.deleteMany(Filters.eq("name", "Yoda"))
    val yoda: Jedi? = col.findOne(Jedi::name eq "Yoda")
    println(yoda?.name)
    "Inserted into collections in different databases"
    println("${System.currentTimeMillis() - before}")


}