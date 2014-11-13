object week3 {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(58); 
  println("Welcome to the Scala worksheet");$skip(44); 
  
  val t1 = new NonEmpty(3, Empty, Empty);System.out.println("""t1  : NonEmpty = """ + $show(t1 ));$skip(21); 
  val t2 = t1 incl 4;System.out.println("""t2  : IntSet = """ + $show(t2 ))}
}


abstract class IntSet {
	def incl(x: Int): IntSet
	def contains(x: Int): Boolean
}

/*class Empty extends IntSet {
	def contains(x: Int): Boolean = false
	def incl(x: Int): IntSet = new NonEmpty(x, new Empty, new Empty)
	override def toString = "."
}*/

class NonEmpty(elem: Int, left: IntSet, right:IntSet) extends IntSet {
	
	def contains(x: Int): Boolean =
		if(x < elem) left contains x
		else if(x > elem) right contains x
		else true
		
	def incl(x: Int): IntSet =
		if(x < elem) new NonEmpty(elem, left incl x, right)
		else if(x > elem) new NonEmpty(elem, left, right incl x)
		else this
		
	override def toString = "{" + left + elem + right + "}"
	
	//singleton object, they are values, so Empty evaluates to itself
	object Empty extends IntSet {
		def contains(x: Int): Boolean = false
		def incl(x: Int): IntSet = new NonEmpty(x, Empty, Empty)
	}
	
	
}

//persistent data structures - the old left tree still exists
