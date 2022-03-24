package com.ibli.spark.core.ds

import java.io.ObjectOutputStream
import java.net.Socket

/**
 * @Author gaolei
 * @Date 2022/3/24 下午8:28
 * @Version 1.0
 */
object Driver {

  def main(args: Array[String]): Unit = {
    val client = new Socket("localhost", 9999);

    val out = client.getOutputStream
    val objOut = new ObjectOutputStream(out)
    val task = new Task()
    objOut.writeObject(task)
    objOut.flush();
    objOut.close();
    client.close()
    println("客户端数据发送完成...")
  }

}
