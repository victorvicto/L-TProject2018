package example

import d3v4._
import graph_dsl._

import scala.scalajs.js
import scala.scalajs.js.annotation.{JSExport, JSExportTopLevel}

object ScalaJSExample_test {

  @JSExportTopLevel("myproject")
  protected def getInstance(): this.type = this

  @JSExport
  def main(args: Array[String]): Unit = {
    val matrix = js.Array[js.Array[Double]](
      js.Array(0, 100, 20, 20, 100, 50, 38),
      js.Array(20, 0, 100, 20, 25, 75, 10),
      js.Array(20, 20, 0, 100, 32, 0, 55),
      js.Array(100, 20, 20, 0, 12, 105, 12),
      js.Array(20, 0, 100, 20, 25, 75, 10),
      js.Array(20, 20, 0, 100, 32, 0, 55),
      js.Array(100, 20, 20, 0, 12, 105, 12)
    )

    var plot = Chord_Plot(matrix, circle_thickness = 10, margin = 20)

    var foo = 4

    var bar = (x: Int) => foo * x

    foo = 5

  }
}
