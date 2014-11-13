package week3

trait List[T] {  
  def isEmpty: Boolean
  def head: T
  def tail: List[T]
}

//val - field definition, = evaluated when the object is first initialized
//def = evaluated each time the object is referenced

class Cons[T](val head: T, val tail: List[T]) extends List[T] {
  def isEmpty = false  
}
class Nil[T] extends List[T]{
  def isEmpty: Boolean = true
  def head: Nothing = throw new NoSuchElementException("Nil.head")
  def tail: Nothing = throw new NoSuchElementException("Nil.tail")
}

