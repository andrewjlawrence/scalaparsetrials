package scalaparsetrial
import fastparse.all._
import fastparse.parsers.Intrinsics


case class TermName(start: Int, length: Int)

abstract class Tree	
{
	def printValue(): Unit = {

	}
}

case class Literal(value: Int) extends Tree
{
	override def printValue(): Unit = {
		println("Literal contains value: " + value)
	}
}

case class Ident(name: TermName) extends Tree
{
	override def printValue(): Unit = {
		println("Ident contains name start index : " + name.start + " and length " + name.length)
	}
}


object ScalaParseTrial extends Literals {
  
	override def Block(): P0 = {
		null
	}

	override def Pattern(): P0 = {
		null
	}

	def parseDigit(string: String): Unit = {
		val parser = P( "{" ~ Index ~ Literals.Int ~  Index ~ "}").map( (x : Tuple2[Int,Int]) => TermName(x._1, x._2 - x._1)).map(Ident)
		val result = parser.parse(string)
		result match {
			case Parsed.Success(value, successIndex) =>
				value.printValue()
			case Parsed.Failure(p,i,e) =>
				println("Parsing failed")
		}   
	}

    def main(args: Array[String]): Unit = {      	
		
    	// Should succeed
		parseDigit("a")
		// Should fail
		parseDigit("{1}")
		// Should succeed
		parseDigit("a1")
    }
}
