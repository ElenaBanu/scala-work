package recfun
import common._

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int = 
    if(c == 0 || r == 0 || c == r)
  		1
  	else
  		pascal(c-1, r-1) + pascal(c, r - 1)  

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {
   	if(chars.isEmpty)
    		throw new java.util.NoSuchElementException
    	else {
	    	def loop(opened: Int, chars: List[Char]): Boolean =
	    		if(chars.isEmpty || opened < 0)
	    			opened == 0	    					
	    		else
	    			if(chars.head == '(')
	    				loop(opened + 1, chars.tail)
	    			else if(chars.head == ')')
	    				loop(opened - 1, chars.tail)
	    			else
	    				loop(opened, chars.tail)
    		loop(0, chars)
    	
  		}
  	}

  /**
   * Exercise 3
   */
   def countChange(money: Int, coins: List[Int]): Int =
   if(money <= 0 && !coins.isEmpty)
		0
	else { 
		def recursive(money: Int, coins: List[Int]) : Int = {	
				if (money < 0)
					0
				else if (coins.isEmpty)
				if (money == 0)  1 else 0    
				else
					recursive(money, coins.tail) + recursive(money - coins.head, coins)
		}
		recursive(money, coins)
	}
}
