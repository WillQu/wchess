package chess.snippet

import net.liftweb._
import http._
import util.Helpers._

import common.Logger

object Chessboard extends Logger {

  def render = {
    trace("Chessboard: render")

    var fen = ""
    def process() = {
      debug("FEN received: " + fen)
    }

    "name=fen" #> SHtml.onSubmit(fen = _) &
    "type=submit" #> SHtml.onSubmitUnit(process)
  }
}
