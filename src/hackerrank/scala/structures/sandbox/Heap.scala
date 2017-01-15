package structures.sandbox

class Heap {
  private var root: HeapNode = _

  def add(value: Int): Unit = {
    if (root == null) {
      root = new HeapNode(value)
    } else {
      root.add(value)
    }
  }

  def pop(): Int = {
    if (root == null) {
      throw new NoSuchElementException("Empty heap!")
    } else {
      val (result, empty) = root.pop()
      if (empty) {
        root = null
      }
      result
    }
  }

  def isEmpty: Boolean = {
    root == null
  }

  override def toString: String = {
    if (root == null) {
      "()"
    } else {
      root.toString
    }
  }

  private class HeapNode(var value: Int) {
    private var descendantCount: Int = 0
    private var left: HeapNode = _
    private var right: HeapNode = _

    def add(newValue: Int): Unit = {
      if (value <= newValue) {
        bubbleDown(newValue)
      } else if (value > newValue) {
        bubbleDown(value)
        value = newValue
      }
    }

    def pop(): (Int, Boolean) = {
      def popRight(): Unit = {
        val (newValue, empty) = right.pop()
        value = newValue
        if (empty) {
          right = null
        }
      }

      def popLeft(): Unit = {
        val (newValue, empty) = left.pop()
        value = newValue
        if (empty) {
          left = null
        }
      }

      val result = value
      if (left == null && right == null) {
        (result, true)
      } else if (left == null && right != null) {
        popRight()
        (result, false)
      } else if (left != null && right == null) {
        popLeft()
        (result, false)
      } else {
        if (left.value < right.value) {
          popLeft()
        } else {
          popRight()
        }
        (result, false)
      }
    }

    def bubbleDown(v: Int): Unit = {
      descendantCount += 1
      if (left == null) {
        left = new HeapNode(v)
      } else if (right == null) {
        right = new HeapNode(v)
      } else {
        if (left.descendantCount < right.descendantCount) {
          left.add(v)
        } else {
          right.add(v)
        }
      }
    }

    override def toString: String = {
      val b = new StringBuilder
      if (left != null) {
        b.append("(").append(left.toString).append(")")
      }
      b.append(value)
      if(right != null) {
        b.append("(").append(right.toString).append(")")
      }
      b.toString()
    }
  }

}

object HeapMain extends App {
  val heap = new Heap
  heap.add(3)
  heap.add(5)
  heap.add(2)
  heap.add(4)
  heap.add(1)
  println(heap)
  println(heap.pop())
  println(heap)
  println(heap.pop())
  println(heap)
  println(heap.pop())
  println(heap)
  println(heap.pop())
  println(heap)
  println(heap.pop())
  println(heap)
}