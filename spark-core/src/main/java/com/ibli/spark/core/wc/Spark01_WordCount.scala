package com.ibli.spark.core.wc

import org.apache.spark.{SparkConf, SparkContext}

/**
 * @Author gaolei
 * @Date 2022/3/15 下午7:11
 * @Version 1.0
 */
object Spark01_WordCount {

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
    val wordGroup = words.groupBy(word => word)
    val word2Count = wordGroup.map {
      case (word, list) => {
        (word, list.size)
      }
    }
    val tuples = word2Count.collect()
    tuples.foreach(println)
    sc.stop();
  }

}

















