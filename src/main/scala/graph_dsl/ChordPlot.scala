package graph_dsl

import d3v4._
import example.ScalaJSExample.groupTicks

import scala.scalajs.js
import org.scalajs.dom.raw
import org.scalajs.dom.raw.CanvasRenderingContext2D

import scala.scalajs.js.annotation.{JSExport, JSExportTopLevel}

case class Chord_Plot (val matrix : matrix, val colors : js.Array[String] = js.Array(), val circle_thickness : Int = 30, val margin : Int = 100) {

  def groupTicks(d: ChordGroup, step: Double, ind: Double): js.Array[js.Dictionary[Double]] = {
    val k: Double = (d.endAngle - d.startAngle) / d.value
    d3.range(0, d.value, step).map((v: Double) => js.Dictionary("value" -> v, "angle" -> (v * k + d.startAngle), "ind" -> ind))
  }
  var mat : js.Array[js.Array[Double]] = matrix.final_matrix


  import d3v4.d3
  val svg = d3.select("svg")
  val width = svg.attr("width").toDouble
  val height = svg.attr("height").toDouble
  val outerRadius = Math.min(width, height) * 0.5 - margin
  val innerRadius = outerRadius - circle_thickness

  val formatValue = d3.formatPrefix(",.0", 1e3)

  val chord = d3.chord().padAngle(0.05).sortSubgroups(d3.descending)

  val arc = d3.arc().innerRadius(innerRadius).outerRadius(outerRadius)

  val ribbon = d3.ribbon().radius(innerRadius)


  var color = js.Array[String]()
  for( i <- 0 until matrix.num_rows){
    if (i < colors.length) {
      color.append(colors(i))
    } else {
      val index = i % beautiful.colors.length
      color.append(beautiful.colors(index))
    }
  }

  val g: Selection[ChordArray] = svg.append("g").attr("transform", "translate(" + width / 2 + "," + height / 2 + ")").datum(chord(mat))

  val group = g.append("g").attr("class", "groups")
    .selectAll("g")
    .data((c: ChordArray) => c.groups)
    .enter().append("g")

  group.append("path").style("fill", (d: ChordGroup) => color(d.index))
    .style("stroke", (d: ChordGroup) => d3.rgb(color(d.index)).darker())
    .attr("d", (x: ChordGroup) => arc(x))

  var groupTick = group.selectAll(".group-tick").data((d: ChordGroup) => groupTicks(d, 1e3, d.index))
    .enter().append("g").attr("class", "group-tick")
    .attr("transform", (d: js.Dictionary[Double]) =>  "rotate(" + (d("angle") * 180 / Math.PI - 90) + ") translate(" + outerRadius + ",0)")

  groupTick.append("line").attr("x2", 6)

  groupTick.filter((d: js.Dictionary[Double]) => d("value") % 5e3 == 0).append("text")
    .attr("class", "name-text")
    .attr("x", 8)
    .attr("dy", ".35em")
    .attr("transform", (d: js.Dictionary[Double]) => if(d("angle") > Math.PI) "rotate(180) translate(-16)" else null)
    .style("text-anchor", (d: js.Dictionary[Double]) => if(d("angle") > Math.PI) "end" else null)
    .text((d: js.Dictionary[Double]) => matrix.rows(d("ind").toInt).name )  //(d: js.Dictionary[Double]) => formatValue(d("value")))

  g.append("g").attr("class", "ribbons").selectAll("path").data((c: ChordArray) => c)
    .enter().append("path")
    .attr("d", (d: Chord) => ribbon(d))
    .style("fill", (d: Chord) => color(d.target.index))
    .style("stroke", (d: Chord) => d3.rgb(color(d.target.index)).darker())
}