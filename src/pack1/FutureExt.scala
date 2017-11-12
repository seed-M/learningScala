package pack1

import scala.concurrent.{ExecutionContext, Future}

object FutureExt {
  import ExecutionContext.Implicits.global
  implicit def FutureExt[T](self: Future[T]) = new FutureExt{
    def exists(p: T => Boolean): Future[Boolean] = {
      self.map {
        p(_)
      }
    }
  }
}

class FutureExt
