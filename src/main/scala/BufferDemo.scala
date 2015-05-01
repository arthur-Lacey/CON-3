/**
 * Demonstrates several objects sequentially accessing shared mutable state.
 *
 * This is a canonical producer/consumer problem.
 */
object BufferDemo extends App {

  //create an empty list of strings
  var buffer = new MutableSLList[String]

  println("buffer contains: " + buffer)

  //Producer puts several strings in the buffer
  for (i <- 0 until 20) {
    println("Producer puts " + i + " of 20")
    buffer += i + " of  20"
  }

  println("buffer contains: " + buffer)

  //Consumer 1 takes half the strings out of the buffer
  for (i <- 0 until 10) println("Consumer 1 takes " + buffer.remove(0))

  //Consumer 2 takes half the strings out of the buffer
  for (i <- 0 until 10) println("Consumer 2 takes " + buffer.remove(0))

  println("buffer contains: " + buffer)

}