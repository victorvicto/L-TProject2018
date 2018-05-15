package d3v4

import scalajs.js
import scalajs.js.{undefined, `|`}
import scala.scalajs.js.annotation._
import org.scalajs.dom

// https://github.com/d3/d3-zoom
@JSImport("d3-zoom", JSImport.Namespace)
@js.native
object d3zoom extends js.Object {
  def zoomInstance(): Transform = js.native
  def zoom[Datum](): ZoomBehavior[Datum] = js.native
  //def zevent(): ZoomEvent = js.native
}

@js.native
trait Transform extends js.Object {
  override def toString: String = js.native
  def applyX(x: Double | js.UndefOr[Double]): Double = js.native
  def applyY(x: Double | js.UndefOr[Double]): Double = js.native
  def apply(point: js.Array[Double]): js.Array[Double] = js.native
  def invertX(x: Double | js.UndefOr[Double]): Double = js.native
  def invertY(x: Double | js.UndefOr[Double]): Double = js.native
  def invert(point: js.Array[Double]): js.Array[Double] = js.native
  def x: Double = js.native
  def y: Double = js.native
  def k: Double = js.native
  def translate(x: Double | js.UndefOr[Double], y: Double | js.UndefOr[Double]): Transform
  def scale(k: Double | js.UndefOr[Double]): Transform
  def on(typenames: String, listener: ListenerFunction0): Transform = js.native
  def scaleExtent(extent: js.Tuple2[Double, Double]): Transform = js.native
}

@js.native
trait ZoomEvent extends BaseEvent {
  def transform: Transform = js.native
  def translate: js.Any = js.native
  def scale: Double = js.native
}

@js.native
trait ZoomBehavior[Datum] extends js.Function1[Selection[Datum], Unit] {
  def on(typenames: String, listener: ListenerFunction0): ZoomBehavior[Datum] = js.native
  def scaleExtent(extent: js.Tuple2[Double, Double]): ZoomBehavior[Datum] = js.native
  def scaleExtent(): js.Array[Double] = js.native
  def scale(scale: Double): ZoomBehavior[Datum] = js.native
  def transform(selection: Selection[Datum], transform: Transform): Transform = js.native
  def translate(translate: js.Tuple2[Double, Double]): ZoomBehavior[Datum] = js.native
  def translateBy(selection: Selection[Datum], x: Double, y: Double): Transform = js.native
  def scaleBy(selection: Selection[Datum], k: Double): Transform = js.native
  def scaleTo(selection: Selection[Datum], k: Double): Transform = js.native
  def clickDistance(distance: Double): ZoomBehavior[Datum] = js.native
  def clickDistance(): Double = js.native
}
