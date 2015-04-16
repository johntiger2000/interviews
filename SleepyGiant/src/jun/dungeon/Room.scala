package jun.dungeon

import jun.dungeon.Direction._

class Room(val id: Int, val name: String) {
  
  var gem: Int = 0
  var corridors: Array[Option[Room]] = new Array[Option[Room]](4)
  
  def getRoom(dir: Direction): Option[Room] = {
    corridors(dir.id)
  }

  def setupCorridors(north: Option[Room], east: Option[Room], south: Option[Room], west: Option[Room]) = {
    corridors(0) = north
    corridors(1) = east
    corridors(2) = south
    corridors(3) = west
  }
  
}