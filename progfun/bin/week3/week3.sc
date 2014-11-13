object week3 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  val t1 = new NonEmpty(3,  new Empty, new Empty) //> t1  : NonEmpty = {.3.}
  val t2 = t1 incl 4                              //> t2  : IntSet = {.3{.4.}}
}


abstract class IntSet {
	def incl(x: Int): IntSet
	def contains(x: Int): Boolean
	def union(other: IntSet): IntSet
}

class Empty extends IntSet {
	def contains(x: Int): Boolean = false
	def incl(x: Int): IntSet = new NonEmpty(x, new Empty, new Empty)
	override def toString = "."
	def union(other: IntSet): IntSet = other
}

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
	
	def union(other: IntSet): IntSet = ((left union right) union other) incl elem
		
	
	}
	
	//singleton object, they are values, so Empty evaluates to itself
	/*object Empty extends IntSet{
		def contains(x: Int): Boolean = false
		def incl(x: Int): IntSet = new NonEmpty(x, Empty, Empty)
	}*/

//persistent data structures - the old left tree still exists

//single inheritance language - only one superclass
//traits = declared like abstract
//classes, objects & traits can inherit from at most one class,
//but arbitrary many traits

//traits cannot have parameters