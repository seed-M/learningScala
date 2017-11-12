package pack

import java.util._
import scala.concurrent._
import ExecutionContext.Implicits.global
import scala.io.Source


object test1 {
  private val timer = new Timer()

  def main(args: Array[String]): Unit = {
    print("Please input the URL you want to browse:")
    val url = Console.readLine()
    val contentFuture = Future {
      val webFile = Source.fromURL(url)
      webFile.mkString
    }

    def printFoo(t: Long) = {
      val p = Promise[Unit]
      timer.schedule(new TimerTask {
        override def run(): Unit = {
          print(".")
          if (contentFuture.isCompleted) {
            print("\n")
            p success()
            timer.cancel()
          }
        }
      }, 0,t)
      p.future
    }

    val prt = printFoo(50)
    val content = for {
      a <- contentFuture
      b <- prt
    } yield a
    content.foreach {
      println(_)
    }

    Thread.sleep(5000)
  }
}
