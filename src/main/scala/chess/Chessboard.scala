package chess.snippet

import scala.xml.NodeSeq

import net.liftweb.common.{Full,Logger}
import net.liftweb.util.PassThru
import net.liftweb.http.S

object Chessboard extends Logger {

  def render (in: NodeSeq): NodeSeq = {
    S.param("FEN") match {
        case Full(fen) =>
        debug("FEN received: " + fen)
        case _ =>
        PassThru
    }
    in
  }
}
