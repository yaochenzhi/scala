import scala.io.StdIn.{readLine, readInt}
import scala.io.Source
import java.io.PrintWriter
import scala.collection.mutable.ArrayBuffer
import scala.math._


object hello {

    def main(args: Array[String]){

        var i = 0
        while( i <= 10 ){
            println("Hello world")
            i += 1
        }

        do{
            println(i)
            i += 1
        }while( i <= 20 )

        for( i <- 1 to 10)
            println("Hello world")

        var numberGuess = 0
        do{
            println("Guess a number ")
            numberGuess = readLine.toInt
        }while(numberGuess != 11)

        println("You've guessed the secret number %d\n", 15)

        var randLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
        for( i <- 0 until randLetters.length)
            println(randLetters(i))

        var aList = List(1, 2, 3, 4, 5)
        for( i <- aList ){
            println("List items " + i)
        }

        var evenList = for { i <-  1 to 20 if ( i % 2 ) == 0 } yield i


        for( i <- 1 to 5; j <- 6 to 10 ){
            println("i : " + i )
            println("j : " + j )
        }

        def sayHi() : Unit = {
            println("Hi how are you")
        }

        sayHi

        def filterPrint() : Int = {
            var pList = List(1, 2, 3, 5, 7, 9)
            for( i <- pList ){
                if ( i != 2 ){
                    println(i)
                }
            }

            i // return i
        }

        println(filterPrint)

        def getSum(args : Int*) : Int = {
            var sum : Int = 0
            for (num <- args){
                sum += num
            }
            sum
        }

        println("Getting sum: " + getSum(1, 2, 3))

        def factorial(num: BigInt) : BigInt = {
            if (num <= 1)
                1
            else
                num * factorial(num - 1)
        }

        println("Factorial of 4 = " + factorial(4))

        /*
        1st : num = 4 * factorial(3)
        2nd : num = 3 * factorial(2)
        3rd : num = 2 * factorial(1)
        */


        val name = "Scala"
        val year = 2020
        val time = 12.27

        println(s"Hello $name")
        println(f"Next year would be ${year + 1} and time now is $time%.2f")
        printf("%5d\n", 5)
        printf("%-5d\n", 5)
        printf("%.5f\n", 3.14)
        printf("'%5s'\n", "hi")

        var words = "Hello world there we go"

        println("The 3rd index of words: " + words(3))
        println(words.concat(" and yes concated"))
        print(words.equals("Hello world there we go"))
        print(words.indexOf("Hello"))

        val wordsArray = words.toArray
        for( v <- wordsArray )
            println(v)


        val favNums = new Array[Int](20)

        val friends = Array("Bob", "Tom")

        friends(0) = "Sue"

        println("Best friends " + friends(0))

        val friends2 = ArrayBuffer[String]()
        friends2.insert(0 , "Phil")

        friends2 += "Mark"

        friends2 ++= Array("Jack", "Paul")

        friends2.insert(1, "Mike", "Mickel", "Michelle")

        friends2.remove(1, 2)

        var friend : String = ""

        for (friend <- friends2 )
            println(friend)

        for (j <- 0 to (favNums.length - 1)){
            favNums(j) = j
            println(favNums(j))
        }

        val favNumsTimes2 = for( num <- favNums ) yield num * 2

        favNumsTimes2.foreach(println)

        var favNumsDiv4 = for( num <- favNums if num % 4 == 0 ) yield num

        favNumsDiv4.foreach(println)

        var mulTable = Array.ofDim[Int](10, 10)

        for ( i <- 0 to 9 ){
            for ( j <- 0 to 9 ){
                mulTable(i)(j) = i * j
            }
        }

        for ( i <- 0 to 9 ){
            for ( j <- 0 to 9 ){
                printf("%d : %d = %d\n", i, j, mulTable(i)(j))
            }
        }

        println("Sum : " + favNums.sum)
        println("Min : " + favNums.min)
        println("Max : " + favNums.max)

        val sortedNums = favNums.sortWith(_>_)
        println(sortedNums.deep.mkString(", "))

        // map imutable

        val employees = Map("Manager" -> "Bob",
                            "Worker" -> "Smith" )

        if (employees.contains("Manager"))
            println(employees("Manager"))

        // map mutable
        val customers = collection.mutable.Map(100 -> "Mike",
                                               101 -> "Mickel",
                                               102 -> "Michelle")

        customers(102) = "Hello world"
        for( (k, v) <- customers )
            printf("%d : %s", k, v)

        // tuple
        var tupleMarge = (103, "Mike", 100.10)
        printf("%s owes us $%.2f\n", tupleMarge._2, tupleMarge._3)

        tupleMarge.productIterator.foreach{ i => println(i) }
        println(tupleMarge.toString())

        // file
        val textWriter = new PrintWriter("test.txt")
        textWriter.write("this is from line1\nthis is from line2")
        textWriter.close

        val textFromFile = Source.fromFile("test.txt", "UTF-8")
        val lineIterator = textFromFile.getLines

        for( line <- lineIterator )
            println(line)
        textFromFile.close

        // exception
        def divideNum(num: Int, div : Int ) = try {
            num / div
        } catch {
            case ex: java.lang.ArithmeticException => "Can't divide by zero"
        } finally {
            println("final")
        }

        println("3 / 0 = ", divideNum(3, 0))


        val log10Func = log10 _
        println(log10Func(1000))
        List(100.0, 1000.0).map(log10Func).foreach(println)
        List(1, 2, 3).map( (x: Int) => x * 50 ).foreach(println)
        List(1, 2, 3).filter(_ % 2 == 0).foreach(println)

        def times3(num : Int) = num * 3
        def times4(num : Int) = num * 4

        def mulIt(func : (Int) => Double, num : Int) = {
            func(num)
        }

        printf("3 * 100 = %.1f\n", mulIt(times3, 100))

        // closures
        val divisorVal = 5
        val divisorFunc = ( num: Double ) => num / divisorVal

        println("5 / 5 = " + divisorFunc(5.0))
    }

}
