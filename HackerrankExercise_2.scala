
// Kundu And Bubble Wrap

// Problem description 
/*
Kundu has a Bubble Wrap and like all of us she likes popping it. 
The Bubble wrap has dimensions NxM, i.e. it has N rows and each row has M cells which has a bubble. 
Initially all bubbles in filled with air and can be popped.

What Kundu does is randomly picks one cell and tries to pop it, 
there might be a case that the bubble Kundu selected is already popped.
In that case he has to ignore this. Both of these steps take 1 second of time.
Tell the total expected number of seconds in which Kundu would be able to pop them all.
*/

// Create object
object Solution {
    // Main method
    def main(args:Array[String]) {
        // Store the input     
        val Array(x,y) = readLine().split(' ').map(_.toInt) // Split the string and save it as int
        val n = x * y // Get the number of bubbles with the dimmesion of the bubble wrap
        val e = new Array[Double](n + 1) // Create an array of with a size n+1
                                          // Use Double to get accuracy
        var i = 1 // Initialize i, which is the bouble about to pop.
      
        while (i <= n) { // Iterates over all the bubbles
          
            // Formula obtained from the coupons collector's problem.
            // it uses geometric distribution.
            e(i) = (e(i - 1) * i + n) / i
            // change to the next bubble
            i += 1
       
    }
        println(e(n)) // Print the accomulated time (last bubble)
    }
}
