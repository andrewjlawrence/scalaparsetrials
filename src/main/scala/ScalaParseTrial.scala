package scalaparsetrial
import fastparse.all._
import fastparse.parsers.Intrinsics


abstract class Tree	
{
	def printValue(): Unit = {

	}
}

case class Literal(value: String) extends Tree
{
	override def printValue(): Unit = {
		println("Literal contains value: " + value)
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
		val parser = P(Literals.Int.!.map(Literal))
		val result = parser.parse(string)
		result match {
			case Parsed.Success(value, successIndex) =>
				println("Parsed a digit with value: " + value.value + " and success index " + successIndex)
			case Parsed.Failure(p,i,e) =>
				println("Parsing failed")
		}   
	}

    def main(args: Array[String]): Unit = {      	
		
    	// Should succeed
		parseDigit("a")
		// Should fail
		parseDigit("1")
		// Should succeed
		parseDigit("a1")
    }
}
