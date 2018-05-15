package graph_dsl

import d3v4._

import scala.io.Source
import scala.scalajs.js

import scala.scalajs.js.annotation.{JSExport, JSExportTopLevel}

/*
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
  val properties: Propert = js.native
}

@js.native
trait Propert extends js.Object {
  val name:String = js.native
}

case class Migration_Map2 () {

  val height = 900
  val width = 900

  val svg = d3.select("svg").attr("width", width).attr("height", height)

  val features = svg.append("g").attr("width", "900").attr("height", "900")

  val path = d3.geoPath().projection(null)

  def funct(json: js.Any): Unit = {
    println("I mean... I'm walkin' here!")
    val world = json.asInstanceOf[MyRootJson]
    val countries = topojson.feature(world, world.objects.countries)

    features.selectAll("path")
      .data(world.objects.countries.geometries)
    .enter()
      .append("path")
      .attr("name", (d:MyGeometries) => {d.properties.name})
      .attr("d", (d:MyGeometries) => {path(countries)})
  }

  val jsFunct: js.Function1[js.Any, Unit] = funct

  d3.json("https://gist.githubusercontent.com/GordyD/49654901b07cb764c34f/raw/27eff6687f677c984a11f25977adaa4b9332a2a9/countries-and-states.json").Then(jsFunct)

}*/