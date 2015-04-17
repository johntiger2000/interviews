package jun.dungeon

import jun.dungeon.Direction._

case class Room(val id: Int, val name: String) {
  
  var gem: Int = 0
  var corridors: Vector[Option[Room]] = Vector.empty
  
  def getRoom(dir: Direction): Option[Room] = {
    corridors(dir.id)
  }

  def setupCorridors(north: Option[Room], east: Option[Room], south: Option[Room], west: Option[Room]) = {
    corridors = Vector(north, east, south, west)
  }
  
}