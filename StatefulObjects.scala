/*
Stateful Objects are that objects which have changeable members or mutable members,
that may vary what transactions or operations were previously performed on the object. 
For a same operation performed many times, the result outputed may be different from previous result’s. 
It is very common to compare stateful objects with real world objects, where the state of the objects changes over-time.
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
// Creating the class
class BankAccount { 
  // Creating states
  private var bal: Int = 0
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
scala> account deposit 100
scala> account withdraw 80
res1: Boolean = true
scala> account withdraw 80
res2: Boolean = false
*/
// Example 2

class waterbottle 
{ 
    // creating states 
    var water: Int = 0
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
        w.fillwater(3) 
        println(w) 
          
        // Changing state 
        w.drinkwater 
        w.drinkwater 
        w.drinkwater 
        w.drinkwater 
    }  
} 