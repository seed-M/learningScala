
import scala.io.Source

object LongLines {
  def processFile(filename: String, width: Int): Unit = {
    val source = Source.fromFile(filename)
    for (line <- source.getLines())

  }
}

def cxw(x: String) = {
  def judge(x: String): Boolean = x match {
    case "如何评价北航cxw？" => true
    case e if e.startsWith("如何评价知乎问题\"") && e.endsWith("\"被知乎删除？") && judge(e.slice(9, e.length -7)) => true
    case _ => false
  }
  if (judge(x)) "如何评价知乎问题\"" + x + "\"被知乎删除？"
  else ""
}