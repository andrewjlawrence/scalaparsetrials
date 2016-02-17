package scalaparsetrial
import fastparse.all._


class LiteralsImpl() extends Literals
{

}

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

object ScalaParseTrial {
	def parseDigit(string: String): Unit = {
		val parser = P(LiteralsImpl.Pattern.Int.map(Literal))
		val result = parser.parse(string)
		result match {
			case Parsed.Success(value, successIndex) =>
				println("Parsed digit 1 with value: " + value.printValue() + " and success index " + successIndex)
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
