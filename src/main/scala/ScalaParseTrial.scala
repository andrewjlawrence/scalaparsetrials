package scalaparsetrial

object ScalaParseTrial extends Core {
import fastparse.all._
	def main(args: Array[String]): Unit = {      	
		println("Starting parsing trials")
		val Parsed.Success(value, successIndex) = StableId.parse("x")
		var xName = AST.TermName(Array[Char](),0,0)
		value match{
			case AST.Ident(name) => xName = name
		}
		println("Parsed x with value: " + xName.name + " and success index: " + successIndex)
	}

	def Block: fastparse.all.P0 = null 
	def Pattern: fastparse.all.P0 = null
}
