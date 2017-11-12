package pack1

import scala.concurrent.Promise
import scala.util.{Failure, Success, Try}

object test2 {
  def main(args: Array[String]): Unit = {
    val test = new Ivar[Int]
    // test()
//    test := 4
    test := 3
    println(test())

  }

  class Ivar[T] {
    private val promise = Promise[T]

    private def foo(x: Option[Try[T]]) = x match {
      case Some(Success(x)) => x
      case Some(Failure(x)) => throw new Exception("unknown exception")
      case None => throw new Exception("unknown exception")
    }

    def apply(): T = {
      if (promise.future.isCompleted)
        foo(promise.future.value)
      else
      throw new Exception("Not assigned yet")
    }

    def :=(x: T): Unit = {
      try {
        promise.success(x)
      } catch {
        case x: Exception => throw new Exception("Assigned Exception")
      }
    }
  }


}
