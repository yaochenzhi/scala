object test_class {

    def main(args: Array[String]){

        val dog1 = new Animal
        dog1.setName("dog")
        dog1.setSound("sound")
        println(dog1.toString)

        val dog2 = new Dog
        dog2.setName("dog2")
        println("The name of dog2: " + dog2.getName)
        println("The dogName of dog2: " + dog2.getDogName)

        val wolf1 = new Wolf("wolf1")
        wolf1.moveSpeed = 35.0
        println(wolf1.move)

        val superman = new Superhero("superman")
        println(superman.fly)
        println(superman.hitByBullet)
        println(superman.ricochet(2500))
    }

    class Animal(var name: String, var sound : String) {
        // no static var or method in scala class

        // protected var name = "No name"

        val id = Animal.newIdNum

        def getName() : String = name

        def getSound() : String = sound

        def this(name: String) {
            this("No name", "No sound")
            this.setName(name)
        }

        def this(){
            this("No name", "No sound")
        }

        def setName(name: String){
            // var declared
            this.name = name
        }

        def setSound(sound: String){
            // var declared
            this.sound = sound
        }

        override def toString() : String = {
            return "%s with the id %d says %s".format(this.name, this.id, this.sound)
        }

    }

    object Animal {
        // create static
        private var idNumber = 0
        private def newIdNum = { idNumber += 1; idNumber }
    }

    class Dog(dogName: String, sound: String, growl: String) extends Animal(dogName, sound) {


        def getDogName() : String = dogName

        /*
        def setDogName(dogName: String) {
            // can not do reassignment to val
            this.dogName = dogName
        }
        */

        def this( name: String, sound: String ) {
            this(name, sound, "No growl")
        }

        def this( name: String ) {
            this(name, "No sound", "No growl")
        }

        def this() {
            this("No name", "No sound", "No growl")
        }

        override def toString() : String = {
            return "This is a dog and its name is %s".format(this.name)
        }
    }


    class AnimalC2(val nameVal: String, val soundVal : String) {

        var name : String = nameVal
        var sound : String = soundVal

        def getName() : String = name

        def getSound() : String = sound

        def getNameVal() : String = nameVal

        /*
        def setNameVal(nameVal : String) {
            // can not do reassignment to val
            try {
                this.nameVal = nameVal   
            } catch {
                case _ => ???
            }
        }
        */

        def setName(nameVal : String){
            try{
                this.name = nameVal
                throw new Exception("Exception thrown from func")
            }catch{
                case t: Throwable => {
                // case e: Exception => {
                    println("Exception caught as expected")
                    t.printStackTrace()
                    // e.printStackTrace()
                }
            }
        }

        def this(){
            this("No name", "No sound")
        }

    }

    abstract class Mammal(val name : String){
        var moveSpeed : Double

        def move : String
    }

    class Wolf(name: String) extends Mammal(name) {
        var moveSpeed = 30.0
        def move = "The wolf %s runs %.2f mph".format(this.name, this.moveSpeed)
    }

    trait Flyable {
        def fly : String
    }

    trait BulletProof {
        def hitByBullet : String

        def ricochet(startSpeed: Double) : String = {
            "The bullet ricochets at a speed of %.1f ft/sec".format(startSpeed * .75)
        }
    }

    class Superhero(val name: String) extends Flyable with BulletProof{
        def fly = "%s flys through the air".format(this.name)
        def hitByBullet = "The bullet bounces off of %s".format(this.name)
    }
}