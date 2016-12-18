package main

import org.scalatest._
import org.neo4j.graphdb._
import org.neo4j.test._

class Neo4JTest extends UnitSpec with BeforeAndAfterEach {

  abstract class RelTypes extends RelationshipType
  case object Knows extends RelTypes {
    val name = "KNOWS"
  }
  
  var graphDb: GraphDatabaseService = _
  
  override def beforeEach() = {
    graphDb = new TestGraphDatabaseFactory().newImpermanentDatabase()
   }
  
  override def afterEach () = {
    graphDb.shutdown()
  }

  "A database" should "store and retrieve values" in {

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

  }
}
