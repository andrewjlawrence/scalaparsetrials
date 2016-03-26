package scalaparsetrial
import fastparse.all._
import fastparse.parsers.Intrinsics

/*
 *
 */

case class Constant(value: Any)

/*
 * Names for things
 */
abstract class Name
{
	def printName(): Unit = {
	}
}

case class TermName(name: Array[Char], start: Int, length: Int)
{
	def toTypeName(): TypeName = {
	    TypeName(name, start, length)
	}
}

case class TypeName(name: Array[Char], start: Int, length: Int)
{
   def toTermName(): TermName = {
       TermName(name, start, length)
   }
}

/*
 * Abstract syntax tree classes.
 */
abstract class Tree	
{
	def printValue(): Unit = {

	}
}

case class Literal(constant: Constant) extends Tree
{
	override def printValue(): Unit = {
		println("Literal")
	}
}

case class Ident(name: TermName) extends Tree
{
	override def printValue(): Unit = {
		println("Ident contains name start index : " + name.start + " and length " + name.length)
	}
}

case class BackquotedIdent(name: TermName) extends Tree
{
	override def printValue(): Unit = {
		println("BackquotedIdent contains name start index : " + name.start + " and length " + name.length)
	}
}

case class This(name: TypeName) extends Tree
{
}

case class Super(tree: Tree, mixin: TypeName) extends Tree

case class Select(tree: Tree, name : Name) extends Tree