package com.ibli.spark.core.wc

import org.apache.spark.{SparkConf, SparkContext}

/**
 * @Author gaolei
 * @Date 2022/3/15 下午7:11
 * @Version 1.0
 */
object Spark02_WordCount {

  /**
   * 准备环境
   * 执行业务操作
   *
   * @param args
   */
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setMaster("local").setAppName("WordCount")
    val sc = new SparkContext(sparkConf);

    val lines = sc.textFile("datas")
    val words = lines.flatMap(_.split(" "))
    val word2One = words.map(
      word => (word, 1)
    )

    val wordGroup = word2One.groupBy(
      t => t._1
    )

    val wordCount = wordGroup.map {
      case (word, list) => {
        list.reduce((t1, t2) => {
          (t1._1, t1._2 + t2._2)
        })
      }
    }

    wordCount.foreach(println)
    sc.stop();
  }

}

















