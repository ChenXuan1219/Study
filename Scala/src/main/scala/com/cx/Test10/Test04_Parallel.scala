package com.cx.Test10

import scala.collection.immutable
import scala.collection.parallel.immutable.ParSeq

/**
 * TODO
 *
 * @author chenxuan
 * @version 1.0.0
 * @since 2022/06/06 19:17
 */
object Test04_Parallel {
  def main(args: Array[String]): Unit = {
    val strings : immutable.IndexedSeq[String]= (1 to 100).map(
      x => Thread.currentThread().getName
    )

    println(strings)

    /**
     * 调用par
     */

  val strings1: ParSeq[Long] = (1 to 100).par.map(
    x => Thread.currentThread().getId
  )

  println(strings1)
}

}
