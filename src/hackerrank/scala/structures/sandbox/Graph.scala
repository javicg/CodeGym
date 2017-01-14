package structures.sandbox

trait Graph {
  def add(v: Int): Unit
  def connect(v1: Int, v2: Int): Unit
  def isConnected(v1: Int, v2: Int): Boolean
  def remove(v: Int): Unit
  def disconnect(v1: Int, v2: Int): Unit
}

class AcyclicUndirectedGraph extends Graph {
  private var adjacencyList = Map.empty[Int, Set[Int]]

  override def add(v: Int): Unit = {
    adjacencyList.get(v) match {
      case None => adjacencyList += (v -> Set.empty)
      case _ =>
    }
  }

  override def connect(v1: Int, v2: Int): Unit = {
    if (v1 == v2) {
      throw new Exception(s"Acyclic graphs do not allow cycles. Vertex [$v1] can't connect with itself")
    }
    if (!adjacencyList.contains(v1)) {
      throw new Exception(s"Vertex [$v1] does not exist in the graph")
    }

    if (!adjacencyList.contains(v2)) {
      throw new Exception(s"Vertex [$v2] does not exist in the graph")
    }

    adjacencyList += (v1 -> (adjacencyList(v1) + v2), v2 -> (adjacencyList(v2) + v1))
  }

  override def remove(v: Int): Unit = {
    adjacencyList.get(v) match {
      case Some(set) => set.foreach(v2 => adjacencyList += (v2 -> (adjacencyList(v2) - v)))
      case _ =>
    }
    adjacencyList -= v
  }

  override def disconnect(v1: Int, v2: Int): Unit = {
    adjacencyList.get(v1) match {
      case Some(set) => adjacencyList += (v1 -> (set - v2))
      case _ =>
    }
    adjacencyList.get(v2) match {
      case Some(set) => adjacencyList += (v2 -> (set - v1))
      case _ =>
    }
  }

  override def toString: String = {
    val b = new StringBuilder
    adjacencyList.foreach(entry =>
      b.append(entry._1)
        .append(" -> ")
        .append(entry._2.mkString("[", ",", "]\n")))
    b.toString()
  }

  override def isConnected(v1: Int, v2: Int): Boolean = {
    adjacencyList.get(v1) match {
      case Some(set) => set.contains(v2)
      case None => false
    }
  }
}

object GraphMain extends App {
  val g = new AcyclicUndirectedGraph
  g.add(1)
  g.add(2)
  g.connect(1, 2)
  g.add(3)
  g.add(4)
  g.connect(1, 3)
  g.connect(2, 4)
  g.remove(1)
//  g.disconnect(4, 2)
  println(g)
  println(g.isConnected(2, 4))
}
