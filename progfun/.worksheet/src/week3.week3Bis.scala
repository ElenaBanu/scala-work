package week3
import week3._

object week3Bis {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(107); 

	def singleton[T](elem: T) = new Cons[T](elem, new Nil[T]);System.out.println("""singleton: [T](elem: T)week3.Cons[T]""");$skip(14); val res$0 = 
	singleton(1);System.out.println("""res0: week3.Cons[Int] = """ + $show(res$0));$skip(18); val res$1 = 
	singleton(false);System.out.println("""res1: week3.Cons[Boolean] = """ + $show(res$1));$skip(161); 
	//type erasure

	def nth[T](n: Int, xs: List[T]): T =
		if(xs.isEmpty) throw new IndexOutOfBoundsException
		else if(n == 0) xs.head
		else nth(n - 1, xs.tail);System.out.println("""nth: [T](n: Int, xs: week3.List[T])T""");$skip(61); 
 
 val list = new Cons(1, new Cons(2, new Cons(3, new Nil)));System.out.println("""list  : week3.Cons[Int] = """ + $show(list ));$skip(16); val res$2 = 
 
 nth(2, list);System.out.println("""res2: Int = """ + $show(res$2));$skip(14); val res$3 = 
 nth(0, list);System.out.println("""res3: Int = """ + $show(res$3));$skip(15); val res$4 = 
 nth(-1, list);System.out.println("""res4: Int = """ + $show(res$4))}
}
