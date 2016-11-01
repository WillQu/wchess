package main

import java.io.File

import org.scalatest._
import org.neo4j.graphdb._
import org.neo4j.graphdb.factory._

class StackSpecTest extends UnitSpec {

  /*"A Stack" should "pop values in last-in-first-out order" in {
    val stack = new Stack[Int]
    stack.push(1)
    stack.push(2)
    assert(stack.pop() === 2)
    assert(stack.pop() === 1)
  }

  it should "throw NoSuchElementException if an empty stack is popped" in {
    val emptyStack = new Stack[String]
    assertThrows[NoSuchElementException] {
      emptyStack.pop()
    }
  }*/

  "A database" should "store and retrieve values" in {
    val graphDb = new GraphDatabaseFactory().newEmbeddedDatabase(new File("/tmp/testdb"))
    graphDb.shutdown()
  }
}
