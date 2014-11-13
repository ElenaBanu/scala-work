package week3
import week3._

object week3Bis {

	def singleton[T](elem: T) = new Cons[T](elem, new Nil[T])
                                                  //> singleton: [T](elem: T)week3.Cons[T]
	singleton(1)                              //> res0: week3.Cons[Int] = week3.Cons@28adcd81
	singleton(false)                          //> res1: week3.Cons[Boolean] = week3.Cons@2a8ee504
	//type erasure

	def nth[T](n: Int, xs: List[T]): T =
		if(xs.isEmpty) throw new IndexOutOfBoundsException
		else if(n == 0) xs.head
		else nth(n - 1, xs.tail)          //> nth: [T](n: Int, xs: week3.List[T])T
 
 val list = new Cons(1, new Cons(2, new Cons(3, new Nil)))
                                                  //> list  : week3.Cons[Int] = week3.Cons@b5d7f70
 
 nth(2, list)                                     //> res2: Int = 3
 nth(0, list)                                     //> res3: Int = 1
 nth(-1, list)                                    //> java.lang.IndexOutOfBoundsException
                                                  //| 	at week3.week3Bis$$anonfun$main$1.nth$1(week3.week3Bis.scala:12)
                                                  //| 	at week3.week3Bis$$anonfun$main$1.apply$mcV$sp(week3.week3Bis.scala:20)
                                                  //| 
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$$anonfun$$exe
                                                  //| cute$1.apply$mcV$sp(WorksheetSupport.scala:76)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$.redirected(W
                                                  //| orksheetSupport.scala:65)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$.$execute(Wor
                                                  //| ksheetSupport.scala:75)
                                                  //| 	at week3.week3Bis$.main(week3.week3Bis.scala:4)
                                                  //| 	at week3.week3Bis.main(week3.week3Bis.scala)
}