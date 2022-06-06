package com.cx.Test10

import scala.collection.immutable.Queue
import scala.collection.mutable

/**
 * TODO
 *
 * @author chenxuan
 * @version 1.0.0
 * @since 2022/06/06 19:09
 */
object Test03_Queue {
  def main(args: Array[String]): Unit = {
    /**
     * 可变队列
     * 方法： 进队 enqueue 出队dequeue
     *
     * 不可变
     * 创建用伴生对象
     */
    val queue : mutable.Queue[String]= new mutable.Queue[String]()

    queue.enqueue("b","a","c")

    println(queue)

    println(queue.dequeue())
    println(queue.dequeue())

    queue.enqueue("e")
    println(queue.dequeue())
    println(queue)

    /**
     * 不可变队列
     */
    val immutableQueue = Queue("a","b","c")

  }
}
