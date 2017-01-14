import java.util.concurrent.TimeUnit

import scala.concurrent.duration.Duration
import scala.concurrent.{Await, Future}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.{Failure, Success}

object Worksheet {

  /* FUTURES */
  val future1 = Future.successful(42)
  val future2 = Future.successful(10)

  val num: Future[Int] = for {
    x <- future1
    y <- future2
  } yield x*y

  val number = Await.result(num, Duration(1, TimeUnit.SECONDS))

  val failed: Future[Int] = Future {
    throw new Exception("BOOM!")
  }

  failed onComplete {
    case Success(x) => "I HAVE A VALUE!"
    case Failure(ex) => ex.getMessage
  }

  failed onSuccess {
    case x => println(x)
  }

  failed onFailure {
    case ex => println(ex.getMessage)
  }

  Await.ready(failed, Duration(1, TimeUnit.SECONDS))

  /* OPTION */
  val opt1 = Some(42)
  val opt2 = Some(10)

  for {
    x <- opt1
    y <- opt2
  } yield x*y
}