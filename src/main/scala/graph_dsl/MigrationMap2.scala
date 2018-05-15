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
  val countries: MyCountries = js.native
}

@js.native
trait MyCountries extends js.Object {
  val geometries:js.Array[MyGeometries] = js.native
}

@js.native
trait MyGeometries extends js.Object {
  val arcs:js.Array[js.Array[js.Array[Int]]] = js.native
  val id: String = js.native
}

case class Migration_Map2 () {

  val height = 900
  val width = 900

  var zoom = d3.zoom()
    .scaleExtent(js.Tuple2(1.0, 8.0))
    .on("zoom", jszoom)

  val svg = d3.select("svg").attr("width", width).attr("height", height).append("g")
    .attr("transform", "translate(-5,-5)")
    .call(zoom)

  var rec = svg.append("rect").attr("width", "100").attr("height", "100").attr("fill", "transparent")

  val features = svg.append("g")

  val path = d3.geoPath().projection(null)

  def onMouse(d: MyGeometries): Unit = {
    rec.text(d.id)
  }

  val oonMouse: ListenerFunction1[MyGeometries] = onMouse

  val zoomed = () => {
    features.attr("transform", "translate(" + d3.event.translate + ")scale(" + d3.event.scale + ")")
    features.select(".state-border").style("stroke-width", 1.5 / d3.event.scale + "px")
    features.select(".county-border").style("stroke-width", .5 / d3.event.scale + "px")
    ()
  }

  val jszoom: ListenerFunction0 = zoomed

  def funct(json: js.Any): Unit = {
    println("I mean... I'm walkin' here!")
    val world = json.asInstanceOf[MyRootJson]
    var countries = topojson.feature(world, world.objects.countries)

    svg.selectAll(".country")
      .data(countries)
      .enter().insert("path", ".graticule")
      .attr("class", "country")
      .attr("d", path)
  }

  val jsFunct: js.Function1[js.Any, Unit] = funct

  println("loltest")
  d3.json("http://bl.ocks.org/mbostock/raw/4090846/world-50m.json").Then(jsFunct)

}