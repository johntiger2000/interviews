package jun.dungeon

import jun.dungeon.Direction._
import scala.collection.mutable.Queue
import scala.util.Random

object World {
  
    var rooms = List(
        new Room(0, "Vermillion"),
        new Room(1, "Ochre"),
        new Room(2, "Chartreuse"),
        new Room(3, "Emerald"),
        new Room(4, "Cobalt"),
        new Room(5, "Aquamarine"),
        new Room(6, "Lavender"),
        new Room(7, "Violet"),
        new Room(8, "Burnt Sienna")
        )
    
    rooms(0).setupCorridors(None, Some(rooms(1)), Some(rooms(5)), None);
    rooms(1).setupCorridors(Some(rooms(0)), Some(rooms(2)), Some(rooms(1)), None);
    rooms(2).setupCorridors(Some(rooms(1)), None, Some(rooms(3)), None);
    rooms(3).setupCorridors(None, Some(rooms(6)), Some(rooms(5)), Some(rooms(4)));
    rooms(4).setupCorridors(Some(rooms(0)), None, Some(rooms(8)), Some(rooms(0)));
    rooms(5).setupCorridors(None, None, Some(rooms(7)), Some(rooms(4)));
    rooms(6).setupCorridors(None, Some(rooms(2)), None, Some(rooms(8)));
    rooms(7).setupCorridors(None, Some(rooms(8)), Some(rooms(8)), Some(rooms(2)));
    rooms(8).setupCorridors(Some(rooms(3)), Some(rooms(6)), None, None);
    
    var player = initPlayer
    var dragon = initDragon
    
  def movePlayer(dir: Direction): Boolean = {
    player.current.getRoom(dir) match {
      case Some(room) => {
        player.current = room
        if (player.current.id == dragon.current.id) {
          player.gem += 1
          var dirs = player.current.corridors.filterNot(_.isEmpty)
          dragon.current = dirs(Random.nextInt(dirs.size)).get
        }
        true
      }
      case _ => false
    }
  }
    
  def moveDragon(): Boolean = {
    getNextRoom(dragon.current, player.current) match {
      case Some(room) => {
        dragon.current = room
        if (player.current.id == dragon.current.id) {
          player = initPlayer
          dragon = initDragon
        }
        true
      }
      case _ => false
    }
  }
  
  def initPlayer(): Creature = {
    new Creature(rooms(Random.nextInt(rooms.size)), 0)
  }
  
  def initDragon(): Creature = {
    if (player == null) {
      player = initPlayer
    }
    new Creature(getFarthestRoom(player.current).get, 1)
  }

  private def getNextRoom(source: Room, dest: Room): Option[Room] = {
    var visited = new Array[List[Room]](rooms.size)
    visited(source.id) = List()
    var queue = new Queue[Room]()
    queue.enqueue(source)
    while (!queue.isEmpty) {
      var current = queue.dequeue
      current.corridors
      .filterNot(_.isEmpty)
      .filter(e => visited(e.get.id) eq null)
      .foreach(e => {
        var room = e.get
        visited(room.id) = visited(current.id) :+ room
        room.id match {
          case dest.id => return visited(room.id).headOption
          case _ => queue.enqueue(room)
        }
      })
    }
    None
  }
  
  private def getFarthestRoom(source: Room): Option[Room] = {
    var visited = new Array[Boolean](rooms.size)
    visited(source.id) = true
    var current = source
    var queue = new Queue[Room]()
    queue.enqueue(source)
    while (!queue.isEmpty) {
      current = queue.dequeue
      current.corridors
      .filterNot(_.isEmpty)
      .filterNot(e => visited(e.get.id))
      .foreach(e => {
        var room = e.get
        visited(room.id) = true
        queue.enqueue(room)
      })
    }
    Some(current)
  }
  
}

