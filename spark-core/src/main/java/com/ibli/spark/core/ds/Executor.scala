package com.ibli.spark.core.ds

import java.io.ObjectInputStream
import java.net.{ServerSocket, Socket}

/**
 * @Author gaolei
 * @Date 2022/3/24 下午8:28
 * @Version 1.0
 */
object Executor {
  def main(args: Array[String]): Unit = {
    val server = new ServerSocket(9999);
    println("服务端启动，等待接受数据。。。")
    val client: Socket = server.accept()

    val in = client.getInputStream
    val objIn = new ObjectInputStream(in)
    val task = objIn.readObject().asInstanceOf[Task]
    val result = task.compute()
    println("计算节点计算结果 : " + result)
    objIn.close();
    client.close();
    server.close();
  }
}
