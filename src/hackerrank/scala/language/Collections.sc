object Worksheet {
  /* LISTS */
  val myList = List(19, 2, 3)
  7 :: myList
  7 +: myList
  myList :+ 7
  myList ++ List(4, 5, 6)
  myList ::: List(4, 5, 6)
  List(4, 5, 6) ++: myList
  myList(1)

  /* SETS */
  val mySet = Set(1, 2, 2, 3, 3, 7)
  mySet + 4
  mySet - 7
  mySet ++ Set(5, 6, 6, 7)
  Set(5, 6, 6, 7) ++ mySet
  mySet -- Set(5, 3, 6, 7)

  /* MAPS */
  val myMap = Map.empty[Int, String]
  val myMap1 = myMap + (1 -> "One")
  myMap1.get(1)
  myMap1.get(2)
  myMap1 - 1
  myMap1 ++ Map(2 -> "Two", 3 -> "Three")

  /* VECTORS */
  val myVector = Vector(1, 2, 3)
  myVector :+ 7
  7 +: myVector
  myVector ++ Vector(4, 5, 6)
  myVector ++: Vector(4, 5, 6)
  myVector(0)

  /* MAP / FLATMAP */
  val list = List(100, 200, 300, 400, 500)
  list.map(el => el * 2)
  list.flatMap(el => List(el))
}