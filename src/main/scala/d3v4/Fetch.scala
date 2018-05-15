package d3v4

import scalajs.js
import scalajs.js.{`|`, undefined}
import scala.scalajs.js.annotation._

@JSImport("d3-fetch", JSImport.Namespace)
@js.native
object d3fetch extends js.Object {
  //def json(a: String, x: (js.Any, js.Any) => Unit): Unit = js.native
  def json(a: String): FetchObject = js.native
}

@js.native
trait FetchObject extends js.Object {
  @JSName("then")
  def Then(x: js.Function): js.Promise[Unit] = js.native
}