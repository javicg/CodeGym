package structures

object Contacts {
  private final val CommandAdd: String = "add"
  private final val CommandFind: String = "find"

  def main(args: Array[String]): Unit = {
    val in = new java.util.Scanner(System.in)
    val n = in.nextLine().toInt

    val trie = new Trie
    for(i <- 1 to n) {
      val command = in.nextLine().split(" ")
      if (CommandAdd.equals(command(0))) {
        trie.add(command(1))
      } else if (CommandFind.equals(command(0))) {
        println(trie.count(command(1)))
      }
    }
  }

  class Trie {
    private val root = new TrieNode

    def add(word: String): Unit = {
      root.add(word)
    }

    def count(prefix: String): Int = {
      root.count(prefix)
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
    }
  }

}
