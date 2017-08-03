package algorithms.search

object ConnectedCellsInAGrid extends App {
  val in = new java.util.Scanner(System.in)

  val n = in.nextLine().toInt
  val m = in.nextLine().toInt

  val matrix = new Array[Array[Int]](n)
  for(i <- 0 until n) {
    matrix(i) = in.nextLine().split("\\s").map(_.toInt)
  }

  val filled = new scala.collection.mutable.Stack[Cell]()
  val nonFilled = new scala.collection.mutable.Stack[Cell]()

  val startingCell = Cell(0, 0)
  if (isFilled(startingCell)) {
    filled.push(startingCell)
  } else {
    nonFilled.push(startingCell)
  }

  var maxCountInRegion = 0
  var currentCount = 0
  var visited = Set.empty[Cell]
  while (filled.nonEmpty || nonFilled.nonEmpty) {
    if (filled.nonEmpty) {
      val cell = filled.pop
      if (!visited.contains(cell)) {
        currentCount += 1
        visit(cell)
      }
    } else {
      if (maxCountInRegion < currentCount) {
        maxCountInRegion = currentCount
      }
      currentCount = 0
      val cell = nonFilled.pop
      if (!visited.contains(cell)) {
        visit(cell)
      }
    }
  }

  println(maxCountInRegion)

  private def visit(cell: Cell): Unit = {
    visited += cell
    val neighbours = allNeighbours(cell).filter(insideMatrix).partition(isFilled)
    neighbours._1.foreach(filled.push)
    neighbours._2.foreach(nonFilled.push)
  }

  private def allNeighbours(cell: Cell): Set[Cell] = {
    Set(
      Cell(cell.i - 1, cell.j),
      Cell(cell.i - 1, cell.j + 1),
      Cell(cell.i, cell.j + 1),
      Cell(cell.i + 1, cell.j + 1),
      Cell(cell.i + 1, cell.j),
      Cell(cell.i + 1, cell.j - 1),
      Cell(cell.i, cell.j - 1),
      Cell(cell.i - 1, cell.j - 1)
    )
  }

  private def insideMatrix(cell: Cell): Boolean = {
    (cell.i >= 0 && cell.i < matrix.length) && (cell.j >= 0 && cell.j < matrix(0).length)
  }

  private def isFilled(cell: Cell): Boolean = {
    matrix(cell.i)(cell.j) == 1
  }

  case class Cell(i: Int, j: Int)
}
