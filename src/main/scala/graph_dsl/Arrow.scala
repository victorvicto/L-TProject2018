package graph_dsl

import d3v4._
import example.ScalaJSExample.groupTicks

import scala.scalajs.js
import scala.scalajs.js.annotation.{JSExport, JSExportTopLevel}

case class Arrow (val x1:Int ,val y1: Int,val x2:Int ,val y2: Int, val width: Int = 7, val textToShow: String = "Nothing") {

  val svg = d3.select("svg")

  val line = svg.append("line")
    .attr("x1",x1)
    .attr("y1",y1)
    .attr("x2",x2)
    .attr("y2",y2)
    .attr("stroke","#44dd44")
    .attr("stroke-width",width)
    .attr("marker-end","url(#arrow)")
    .on("mouseover", () => d3.select("#num").text(textToShow))
}