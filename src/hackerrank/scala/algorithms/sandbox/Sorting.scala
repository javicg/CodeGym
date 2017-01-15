package algorithms.sandbox

import structures.sandbox.Heap

import scala.util.Random

object Sorting {

  def insertionSort(array: Array[Int]): Array[Int] = {
    for (i <- array.indices) {
      val el = array(i)
      var j = i
      while (j > 0 && array(j - 1) > el) {
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

  def mergeSort(array: Array[Int]): Array[Int] = {
    def merge(arr1: Array[Int], arr2: Array[Int]): Array[Int] = {
      val result = Array.ofDim[Int](arr1.length + arr2.length)
      var id1 = 0
      var id2 = 0
      while (id1 < arr1.length && id2 < arr2.length) {
        if (arr1(id1) > arr2(id2)) {
          result(id1 + id2) = arr2(id2)
          id2 += 1
        } else {
          result(id1 + id2) = arr1(id1)
          id1 += 1
        }
      }

      if (id1 < arr1.length) {
        for(i <- id1 until arr1.length) {
          result(arr2.length + i) = arr1(i)
        }
      } else if (id2 < arr2.length) {
        for(i <- id2 until arr2.length) {
          result(arr1.length + i) = arr2(i)
        }
      }
      result
    }

    if (array.length < 2) {
      array
    } else {
      val middle = array.length / 2
      val arr1 = mergeSort(array.slice(0, middle))
      val arr2 = mergeSort(array.slice(middle, array.length))
      merge(arr1, arr2)
    }
  }

}

object SortingMain extends App {
  val r = new Random()
  val n = 100000
  val sample = (1 to n).map(_ => r.nextInt(n)).toArray

  benchmark("Heap Sort", Sorting.heapSort, sample)
  benchmark("Insertion Sort", Sorting.insertionSort, sample)
  benchmark("Merge Sort", Sorting.mergeSort, sample)

  def benchmark(name: String, alg: Array[Int] => Array[Int], arr: Array[Int]): Array[Int] = {
    val copy = Array.ofDim[Int](arr.length)
    arr.copyToArray(copy)
    val start = System.currentTimeMillis()
    val result = alg(copy)
    val end = System.currentTimeMillis()

    println(s"== $name")
//    println(s"== Result: " + result.mkString("[", ",", "]"))
    println(s"== Algorithm took ${end - start} ms\n")
    result
  }
}
