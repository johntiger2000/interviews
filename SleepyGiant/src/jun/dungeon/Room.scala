package jun.dungeon

import jun.dungeon.Direction._

case class Room(val id: Int, val name: String) {
  
  var gem: Int = 0
  private var _corridors: Vector[Option[Room]] = _
  
  def getRoom(dir: Direction): Option[Room] = {
    if (dir.id >= corridors.size) {
      return None
    }
    corridors(dir.id)
  }
  
  def corridors = {
    if (_corridors eq null) {
      throw new RuntimeException("Room %d (name = %s) has no corridors defined!".format(id, name))
    }
    _corridors
  }
  
//  def corridors_=(north: Option[Room], east: Option[Room], south: Option[Room], west: Option[Room]) = {
//    _corridors = Vector(north, east, south, west)
//  }
  
  def corridors_=(directions: Vector[Option[Room]]) = {
    if (directions.size != Direction.size) {
      throw new RuntimeException("Room %d (name = %s) needs to have %d corridors defined!".format(id, name, Direction.size))
    }
    _corridors = directions
  }
  
}