package structures.sandbox

class Trie {
  private val root = new TrieNode

  def add(word: String): Unit = {
    root.add(word)
  }

  def count(prefix: String): Int = {
    root.count(prefix)
  }

  override def toString: String = {
    root.toString
  }
}

class TrieNode {
  private var children: Map[Char, TrieNode] = Map.empty
  private var definesWord = false
  private var numWordsWithPrefix = 0

  def add(word: String): Unit = {
    numWordsWithPrefix += 1
    if (!word.isEmpty) {
      val firstChar = word.head
      children.get(firstChar) match {
        case Some(child) =>
          child.add(word.tail)
        case None =>
          val newChild = new TrieNode
          children += firstChar -> newChild
          newChild.add(word.tail)
      }
    } else {
      definesWord = true
    }
  }

  def count(prefix: String): Int = {
    if (prefix.isEmpty) {
      numWordsWithPrefix
    } else {
      val firstChar = prefix.head
      children.get(firstChar) match {
        case Some(child) => child.count(prefix.tail)
        case None => 0
      }
    }
  }

  override def toString: String = {
    getAllWords.toString
  }

  private def getAllWords: Iterable[String] = {
    def getAllWords(c: Char, node: TrieNode): Iterable[String] = {
      val words = node.getAllWords.map(c + _)
      if (node.definesWord) {
        words ++ Iterable(c.toString)
      } else {
        words
      }
    }

    if (children.isEmpty) {
      Iterable.empty
    } else {
      children.flatMap(entry => getAllWords(entry._1, entry._2))
    }
  }
}

object TrieMain extends App {
  val trie = new Trie
  trie.add("Hello")
  println(trie.count("He"))
  trie.add("He")
  trie.add("Hem")
  println(trie.count("He"))
  println(trie.count("Hel"))
  println(trie.count("Helsinki"))
  println(trie.count(""))
  trie.add("Yummy")
  println(trie.count("Y"))
  println(trie)
}
