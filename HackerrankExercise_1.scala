// Create object
object Solution {
  //Main method
  def main(args: Array[String]) {
    readLine  // Reads the first line of the input 
    val numbers = readLine.split(" ").map(_.toInt) //Read the second line of the input,
                                                    //Separate by space and change to input.
    println(solution(numbers)) // Print the solution
  }

  // Defining method
  def solution(numbers: Array[Int]): String = {
    /* Returns a sring with numbers divisuble by 101
    Args:
        numbers: Array of numbers
    Return:
        String: String with the operators correctly set to do an operation
        with a result divisible by 101
    */

    var incomplete: String = null // Initialize the variable, where the string is saved
    var until: Int = 0 // Flag for inconsistencies

    // Defining nested method
    def sol(i: Int, accumulated: Int, expression: String) {
    /* Returns a sring with numbers divisuble by 101
    Args:
        i : integer, position of the number in the array.
        acc: integer, the accumulate of the operation. 
        expression: string, the string of the operations made. 
    Return:
        String: String with the operators correctly set to do an operation

    */
      // Initial condition to start 
      if (incomplete == null) {
        // Condition for completion
        if (accumulated % 101 == 0) {
          // Raise the flag, to count the position of the error in the string
          until = i
          // Set the espression to incomplete
          incomplete = expression
        // Otherwise continue with the recursivity, until 'i' has reached the size of the array 
        } else if (i < numbers.size) {
          // First recursion with the sum
          sol(i + 1, accumulated + numbers(i), expression + "+" + numbers(i))
          // Second recursion with the subtraction
          sol(i + 1, accumulated - numbers(i), expression + "-" + numbers(i))
          // Third recurusion with the multiplication
          sol(i + 1, accumulated * numbers(i), expression + "*" + numbers(i))
        }
      }
    }
    // Call funtion with the first position, and the first number of the array as arguments 
    sol(1, numbers(0), "" + numbers(0))

    
    // Set the class StringBuilder to create a mutable string to store the string
    val builder = new StringBuilder()
    builder.append(incomplete) // Append incomplete to the builder
    for (i <- until to numbers.size - 1) {
      // From the flag was raised add the missing opperation * 
        builder.append("*" + numbers(i))
    }
    // Return the final string
    builder.toString 

  }

}
