package graph_dsl

import scala.scalajs.js

case class matrix (val firstM: js.Array[js.Array[Double]] = js.Array(), val names: js.Array[String] = js.Array()) {
  var num_rows: Int = firstM.length
  if (names.length != num_rows) {
    throw new IllegalArgumentException("You didn't provide the right amount of names (one name per row in the matrix).")
  }
  var rows: js.Array[row] = js.Array[row]()
  for (i <- 0 to num_rows-1) {
    if(firstM(i).length != num_rows) {
      throw new IllegalArgumentException("Your matrix isn't square, the number of rows should be equal to the number of elements in each row.")
    }
    rows.append(new row(firstM(i), names(i), i))
  }

  var final_matrix :js.Array[js.Array[Double]] = firstM

  def addRow(vals: js.Array[Double], name: String): Unit = {
    if (vals.length!=num_rows+1) {
      throw new IllegalArgumentException("The number of values in your new row should be equal to the previous number of rows in your matrix plus 1.")
    }
    val r = new row(vals, name, num_rows)
    final_matrix.append(vals)
    for (i <- 0 until num_rows) {
      final_matrix(i).append(0.0)
      rows(i).values.append(0.0)
    }
    rows.append(r)
    num_rows += 1
  }

  def addMatrix(mat: js.Array[js.Array[Double]], newNames: js.Array[String]): Unit = {
    // check is added matrix is a valid matrix
    if (mat.length != newNames.length) {
      throw new IllegalArgumentException("You didn't provide the right amount of names (one name per row in the matrix).")
    }
    for (i <- 0 until mat.length) {
      if (mat(i).length != (newNames.length + final_matrix.length)) {
        throw new IllegalArgumentException("The length of each new row in the matrix you want to append should be equal to the total length of the final matrix (number of rows of the old matrix + number of rows in the appended matrix).")
      }
    }

    // change size of matrix
    for (i <- final_matrix.length until mat(0).length) {
      for (j <- 0 until num_rows) {
        final_matrix(j).append(0.0)
        rows(j).values.append(0.0)
      }
    }

    //add all new rows
    for (i <- 0 until mat.length) {
      var r = new row(mat(i), newNames(i), num_rows+i)
      final_matrix.append(mat(i))
      rows.append(r)
      num_rows += 1
    }
  }

  def addIndepMatrix(mat: js.Array[js.Array[Double]], newNames: js.Array[String]): Unit = {
    // check if square
    if (mat.length != newNames.length) {
      throw new IllegalArgumentException("You didn't provide the right amount of names (one name per row in the matrix).")
    }
    for (i <- 0 until mat.length) {
      if (mat(i).length != newNames.length ) {
        throw new IllegalArgumentException("Your matrix isn't square.")
      }
    }

    // transform the matrix to add
    var newmat = js.Array[js.Array[Double]](js.Array(0.0))
    for (j <- 1 until num_rows) {
      newmat(0).append(0.0)
    }
    for (j <- 0 until mat.length) {
      newmat(0).append(mat(0)(j))
    }

    for (i <- 1 until mat.length) {
      var newRow = js.Array[Double](0.0)
      for (j <- 1 until num_rows) {
        newRow.append(0.0)
      }
      for (j <- 0 until mat.length) {
        newRow.append(mat(i)(j))
      }
      newmat.append(newRow)
    }

    addMatrix(newmat, newNames)
  }

  def modify(irow : Int, icol:Int, newVal:Double): Unit = {
    final_matrix(irow)(icol) = newVal
    rows(irow).values(icol) = newVal
  }

  def modifyRow(irow : Int, newVal:js.Array[Double]): Unit = {
    if (newVal.length != num_rows) {
      throw new IllegalArgumentException("Your new array doesn't have the right length (it's length should be equal to the total number of rows in the final matrix).")
    }
    final_matrix(irow) = newVal
    rows(irow).values = newVal
  }

  def getRowIdByName(nom : String): Int = {
    var rowId = -1
    for (i <- 0 until num_rows) {
      if(rows(i).name == nom) {
        rowId = i
        println("found")
      }
    }
    rowId
  }

  def toMatrix() : js.Array[js.Array[Double]] = {
    final_matrix
  }
}

case class row (var values: js.Array[Double], var name: String, val index: Int)