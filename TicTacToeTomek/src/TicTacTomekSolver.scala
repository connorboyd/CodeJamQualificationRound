import scala.io._

object TicTacTomekSolver {
  
  def main(args: Array[String]) = {
    readInput
  }
  
  def readInput = {
    var fileName = "file.in"
    val s = Source.fromFile(fileName)
//    s.getLines.foreach((line) => {
//      println(line)
//    })
    
    val lines = s.getLines().toList
//    val size = lines.apply(0)
//    println(size)
    
  }

}