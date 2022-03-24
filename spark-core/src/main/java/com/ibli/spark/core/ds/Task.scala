package com.ibli.spark.core.ds

/**
 * @Author gaolei
 * @Date 2022/3/24 下午8:36
 * @Version 1.0
 */
class Task {

  val datas = List(1, 2, 3, 4)

  val logic = (num: Int) => {
    num * 2
  }

  val logic2: (Int) => Int = _ * 2

  def compute() = {
    datas.map(logic)
  }

}
