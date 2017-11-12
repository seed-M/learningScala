package pack1

import scala.concurrent.{ExecutionContext, Future}


object test3 {
  def main(args: Array[String]): Unit = {
    import FutureExt.FutureExt
    import ExecutionContext.Implicits.global
    val fu = Future {
      Thread.sleep(200)
      println("me first")
      "hello"
    }
    fu.exists{
      case "hello"=>true
      case _=>false
    }.foreach{
      case true=>println("true")
      case false=>println("false")
    }
    //fu.isCompleted
    Thread.sleep(2000)
  }

}

