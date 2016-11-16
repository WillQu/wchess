package main

import java.io.File
import java.nio.file.Files

import org.scalatest._
import org.neo4j.graphdb._
import org.neo4j.graphdb.factory._

class Neo4JTest extends UnitSpec {

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

  abstract class RelTypes extends RelationshipType
  case object Knows extends RelTypes {
    val name = "KNOWS"
  }

  "A database" should "store and retrieve values" in {
    val dbFile = Files.createTempDirectory("testdb").toFile()
    val graphDb = new GraphDatabaseFactory().newEmbeddedDatabase(dbFile)

    val writeTx = graphDb.beginTx()
    val firstNode = graphDb.createNode()
    firstNode.setProperty( "message", "Hello, " )
    val secondNode = graphDb.createNode()
    secondNode.setProperty( "message", "World!" )

    val relationship = firstNode.createRelationshipTo( secondNode, Knows)
    relationship.setProperty( "message", "brave Neo4j " )

    assert(firstNode.getProperty( "message" ) === "Hello, ")
    assert(relationship.getProperty( "message" ) === "brave Neo4j ")
    assert(secondNode.getProperty( "message" ) === "World!")

    writeTx.success()

    graphDb.shutdown()
  }
}
