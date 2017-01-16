package structures

object NoPrefixSet {
  def main(args: Array[String]): Unit = {
    val in = new java.util.Scanner(System.in)
    val n = in.nextLine().toInt

    val trie = new Trie
    var earlyExit = false
    var i = 0
    while (!earlyExit && i < n) {
      val word = in.nextLine()
      if (trie.add(word)) {
        println("BAD SET")
        println(word)
        earlyExit = true
      }
      i += 1
    }
    if (!earlyExit) {
      println("GOOD SET")
    }

  }

  class Trie {
    private val root = new TrieNode

    def add(word: String): Boolean = {
      root.add(word)
    }

    class TrieNode {
      private var children: Map[Char, TrieNode] = Map.empty
      private var definesWord = false

      def add(word: String): Boolean = {
        add(word, noNewNodeExists = true)
      }

      def add(word: String, noNewNodeExists: Boolean): Boolean = {
        if (definesWord) {
          return true
        }
        if (!word.isEmpty) {
          val firstChar = word.head
          val addResult = children.get(firstChar) match {
            case Some(child) =>
              child.add(word.tail, noNewNodeExists = noNewNodeExists)
            case None =>
              val newChild = new TrieNode
              children += firstChar -> newChild
              newChild.add(word.tail, noNewNodeExists = false)
          }
          return addResult
        } else {
          definesWord = true
          if (noNewNodeExists) {
            return true
          }
        }
        false
      }
    }

  }

}
