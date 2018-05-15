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
    val mat = matrix(js.Array[js.Array[Double]](
      js.Array(0,1,2,2,3,0,0),
      js.Array(20, 20, 0, 100, 32, 0, 55),
      js.Array(100, 20, 20, 0, 12, 105, 12),
      js.Array(20, 0, 100, 20, 25, 75, 10),
      js.Array(20, 20, 0, 100, 32, 0, 55),
      js.Array(0, 0, 50, 10, 12, 37, 5),
      js.Array(0, 20, 20, 0, 12, 105, 12)
    ),
      js.Array("Alice","Bernard","Charles","Damien","Elise","Florian","Guy"))

    /*mat.addMatrix( js.Array[js.Array[Double]](
      js.Array(0,0,0,0,0,0,0,0,0,5,0),
      js.Array(0,0,0,0,0,0,0,0,3,0,6),
      js.Array(0,0,0,0,0,0,0,0,8,0,0),
      js.Array(0,0,0,0,0,0,0,6,0,0,0)
    ),
      js.Array("Harry","Ines","Jack","Kirikou")
    )

    mat.addIndepMatrix( js.Array[js.Array[Double]](
      js.Array(0,100,100,100),
      js.Array(1,0,0,0),
      js.Array(0,18,0,29),
      js.Array(16,0,0,0)
    ),
      js.Array("Lola","Martin","Natan","Ophélie")
    )

    mat.addRow(js.Array(0,0,0,100,0,0,0,12), "Pierre")

    mat.modify(0,1,100)
    println(mat.getRowIdByName("Bernard"))
    mat.modifyRow(mat.getRowIdByName("Bernard"),js.Array(0,0,0,100,0,0,0,0))*/

    val col = js.Array("#5555dd", "#6644dd", "#7755d4", "#11a1ff", "#4652dd", "#6461bd", "#aaaaff")

    //var plot = Chord_Plot(mat, margin = 100, circle_thickness = 10, colors = js.Array("#5555dd", "#6644dd", "#7755d4", "#11a1ff", "#4652dd", "#6461bd", "#aaaaff", "#8181dd", "#5555dd", "#6644dd", "#7755d4", "#11a1ff", "#4652dd", "#6461bd", "#aaaaff", "#8181dd"))
    var plot = Migration_Map()
    val arr1 = new Arrow(100,120,280,180,14,"Oregon to Wyoming : 14.000 people")
    val arr2 = new Arrow(450,450,595,265,10,"Texas to Illinois : 10.000 people")
    val arr3 = new Arrow(440,460,120,500,4,"Texas to Alaska: 4.000 people")
  }
}
