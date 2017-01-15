package algorithms.sandbox

import structures.sandbox.Heap

import scala.util.Random

object Sorting {

  def insertionSort(array: Array[Int]): Array[Int] = {
    for (i <- array.indices) {
      val el = array(i)
      var j = i
      while (j > 0 && array(j - 1) < el) {
        array(j) = array(j - 1)
        j -= 1
      }
      array(j) = el
    }
    array
  }

  def heapSort(array: Array[Int]): Array[Int] = {
    val heap = new Heap
    array.foreach(heap.add)

    val result = Array.ofDim[Int](array.length)
    for (i <- array.indices) {
      result(i) = heap.pop()
    }
    result
  }

}

object SortingMain extends App {
  def benchmark(name: String, alg: Array[Int] => Array[Int], arr: Array[Int]): Array[Int] = {
    val copy = Array.ofDim[Int](arr.length)
    arr.copyToArray(copy)
    val start = System.currentTimeMillis()
    val result = alg(copy)
    val end = System.currentTimeMillis()

    println(s"== $name")
    println(s"== Algorithm took ${end - start} ms\n")
    result
  }

  val r = new Random()
  val n = 100000
  val sample = (1 to n).map(_ => r.nextInt(n)).toArray

  benchmark("Heap Sort", Sorting.heapSort, sample)
  benchmark("Insertion Sort", Sorting.insertionSort, sample)
}
