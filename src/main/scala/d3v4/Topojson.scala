package d3v4

import scalajs.js
import scalajs.js.{undefined, `|`}
import scala.scalajs.js.annotation._

@JSImport("topojson-client", JSImport.Namespace)
@js.native
object topojson extends js.Object {
  //                 Zhutian Chen  <https://github.com/chenzhutian>
  def bbox(topology: js.Any): js.Dynamic = js.native
  def feature(topology: js.Any, o: js.Any): js.Any = js.native
  def filter(topology: js.Any, filter: js.Any): js.Dynamic = js.native
  def filterAttached(topology: js.Any): js.Dynamic = js.native
  def filterAttachedWeight(topology: js.Any, minWeight: js.Any, weight: js.Any): js.Dynamic = js.native
  def filterWeight(topology: js.Any, minWeight: js.Any, weight: js.Any): js.Dynamic = js.native
  def merge(topology: js.Any, args: js.Any*): js.Any = js.native
  def mergeArcs(topology: js.Any, objects: js.Any): js.Dynamic = js.native
  def mesh(topology: js.Any, args: js.Any*): js.Any = js.native
  def meshArcs(topology: js.Any, `object$$1`: js.Any, filter: js.Any, args: js.Any*): js.Any = js.native
  def neighbors(objects: js.Any): js.Array[js.Any] = js.native
  def planarRingArea(ring: js.Any): js.Dynamic = js.native
  def planarTriangleArea(triangle: js.Any): js.Dynamic = js.native
  def presimplify(topology: js.Any, weight: js.Any): js.Array[js.Any] = js.native
  def quantile(topology: js.Any, p: js.Any): js.Dynamic = js.native
  def quantize(topology: js.Any, transform: js.Any): js.Dynamic = js.native
  def simplify(topology: js.Any, minWeight: js.Any): js.Dynamic = js.native
  def sphericalRingArea(ring: js.Any, interior: js.Any): js.Dynamic = js.native
  def sphericalTriangleArea(t: js.Any): js.Dynamic = js.native
  def topology(objects: js.Any, quantization: js.Any): js.Dynamic = js.native
  def transform(transform: js.Any): js.Dynamic = js.native
  def untransform(transform: js.Any): js.Dynamic = js.native
}