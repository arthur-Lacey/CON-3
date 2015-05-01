/**
 * Demonstrates several objects concurrently accessing shared mutable state.
 *
 * This is a canonical producer/consumer problem.
 *
 * We want the consumers to block if there are no items to consume.
 */
object ThreadedBufferDemo extends App {

  //create an empty list of strings
  var buffer = new MutableSLList[String]

  println("buffer contains: " + buffer)

  //thread for Producer
  val producerThread = new Thread {
    override def run {
      //Producer puts several strings in the buffer
      for (i <- 0 until 20) {
        Thread.sleep(2000)
        println("Producer puts " + i + " of 20")
        buffer += i + " of  20"
      }
    }
  }

  //thread for Consumer 1
  val consumer1Thread = new Thread {
    override def run {
      //Consumer 1 takes half the strings out of the buffer
      for (i <- 0 until 10) {
        Thread.sleep(500) //arbitrary delay
        println("Consumer 1 takes " + buffer.remove(0))
      }
    }
  }

  //thread for Consumer 2
  val consumer2Thread = new Thread {
    override def run {
      //Consumer 2 takes half the strings out of the buffer
      for (i <- 0 until 10) {
        Thread.sleep(1000) //arbitrary delay
        println("Consumer 2 takes " + buffer.remove(0))
      }
    }
  }

  println("buffer contains: " + buffer)

  producerThread.setName("Producer")
  producerThread.start()
  
  consumer1Thread.setName("Consumer 1")
  consumer1Thread.start()
  
  consumer2Thread.setName("Consumer 2")
  consumer2Thread.start()
  
  producerThread.join(15000)
  consumer1Thread.join(15000)
  consumer2Thread.join(15000)
   
  println("buffer contains: " + buffer)
}