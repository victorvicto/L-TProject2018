package graph_dsl

import d3v4._

import scala.io.Source
import scala.scalajs.js

import scala.scalajs.js.annotation.{JSExport, JSExportTopLevel}

@js.native
trait MyRootJson extends js.Object {
  val objects:MyJson= js.native
}

@js.native
trait MyJson extends js.Object {
  val states:MyState = js.native
  val nation:MyNation = js.native
  val counties:MyCounties = js.native
}

@js.native
trait MyState extends js.Object {
  val geometries:js.Array[MyGeometries] = js.native
}

@js.native
trait MyCounties extends js.Object {
  val geometries:js.Array[MyGeometries] = js.native
}

@js.native
trait MyNation extends js.Object {
  val geometries:js.Array[MyGeometries] = js.native
}

@js.native
trait MyGeometries extends js.Object {
  val arcs:js.Array[js.Array[js.Array[Int]]] = js.native
  val id: String = js.native
}

case class Migration_Map () {

  val height = 900
  val width = 900

  val svg = d3.select("svg").attr("width", "fill-parent").attr("height", height)

  val features = svg.append("g")

  val path = d3.geoPath().projection(null)

  def funct(json: js.Any): Unit = {
    println("I mean... I'm walkin' here!")
    val us = json.asInstanceOf[MyRootJson]
    features.append("path")
      .datum(topojson.feature(us, us.objects.nation))
      .attr("class", "state")
      .attr("d", path)

    features.append("path")
      .datum(topojson.mesh(us, us.objects.states, (a: js.Any, b: js.Any) => { a != b }))
      .attr("class", "state-border")
      .attr("d", path)
      .style("stroke-width", "1.5px")
  }

  val jsFunct: js.Function1[js.Any, Unit] = funct

  d3.json("https://unpkg.com/us-atlas@1/us/10m.json").Then(jsFunct)

}