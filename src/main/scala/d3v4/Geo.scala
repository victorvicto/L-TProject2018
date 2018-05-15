package d3v4

import scalajs.js
import scalajs.js.{undefined, `|`}
import scala.scalajs.js.annotation._

// https://github.com/d3/d3-axis

@JSImport("d3-geo", JSImport.Namespace)
@js.native
object d3geo extends js.Object {
  def geoPath(): PathGenerator  = js.native
}

@js.native
trait GeoLayout extends js.Object{
  //def path(): Path = js.native
}

@js.native
trait PathGenerator extends js.Object{
  def projection(pro: js.Any*): js.Function1[js.Any, String] = js.native
}

@js.native
trait PGenerator extends js.Object{
  def apply(arguments: js.Any): String = js.native
}