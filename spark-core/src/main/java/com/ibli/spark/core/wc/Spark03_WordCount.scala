package com.ibli.spark.core.wc

import org.apache.spark.{SparkConf, SparkContext}

/**
 * @Author gaolei
 * @Date 2022/3/15 下午7:11
 * @Version 1.0
 */
object Spark03_WordCount {

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

    // Spark 提供了更多的功能，把分组和聚合用一个方法实现
    val wordCount = word2One.reduceByKey(_ + _)
    // word2One.reduceByKey((x, y) => {x + y})

    wordCount.foreach(println)
    sc.stop();
  }

}

















