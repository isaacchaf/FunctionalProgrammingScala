
/////////////////////////////////////////////////
// Chapter 18. Stateful Objects
/////////////////////////////////////////////////

/*
  Stateful Objects are that objects which have changeable members or mutable members,
  that may vary what transactions or operations were previously performed on the object. 
  For a same operation performed many times, the result outputed may be different from previous result’s. 
  It is very common to compare stateful objects with real world objects, where the state of the objects changes over-time.
  
  The stateful objects are easy to identify, since this include the var insted of val, but this idea is not always true
  because an object without a var's can inherit another object that actually has a var. 
*/

// Syntax

/*
  class classname
  {
       // declaring some states that are mutable
       var state1
       var state2
       def changestate
       {
            // some operation to change the states of the object
       }
  }
*/

// Example
/*
      When we talk about stateful objects one main example is a bank account, 
      which its balance changes over time.
*/

// Creating the class
class BankAccount { 
  // Creating states
  private var bal: Int = 0  // This variable will change
  def balance: Int = bal
  
  // Defining Method 
  def deposit(amount: Int) {
    
    require(amount > 0)
    bal += amount  
    
  }
  // Defining method
  def withdraw(amount: Int): Boolean =
  
    if (amount > bal) false
  
    else {
      
      bal -= amount
      true
  }
}

// Output Example

/*
    scala> val account = new BankAccount
    account: BankAccount = BankAccount@bf5bb7
    scala> account deposit 100     //The original deposit
    scala> account withdraw 80     //The balance var has been modified 
    res1: Boolean = true
    scala> account withdraw 80     
    res2: Boolean = false
*/
// Example 2

class waterbottle 
{ 
    // creating states 
    var water: Int = 0 // This variable will change
    def drinkwater = {  
        if(water > 0) 
        { 
            water = water-1
            println("water left = "+water) 
        } 
        else
        { 
            println("waterbottle empty fill water") 
        } 
    } 
      
    // Defining method 
    def fillwater (c: Int)=
    { 
        if(water + c > 5) 
        { 
            water = 5
        } 
        else
        {  
            water = water + c 
        } 
    } 
    override def toString= "water in bottle = " + water 
} 
  
// Creating object 
object GFG  
{ 
    // Main method  
    def main(args: Array[String])  
    {  
        // waterbottle object 
        var w = new waterbottle 
          
        // calling  
        w.fillwater(3)    // water in bottle = 3
        println(w) 
          
        // Changing state 
        w.drinkwater   // water left = 2
        w.drinkwater   // water left = 1
        w.drinkwater   // water left = 0
        w.drinkwater   // waterbottle empty fill water
    }  
} 

/////////////////////////////////////////////////
// References 
/////////////////////////////////////////////////

//  https://people.cs.ksu.edu/~schmidt/705a/Scala/Programming-in-Scala.pdf
//  https://www.geeksforgeeks.org/scala-stateful-object/
