package jun.dungeon

object Main {

  def main(args: Array[String]): Unit = {
    
    World.initPlayer
    World.initDragon
    
    println("World created.")
    while (true) {
      for (a <- 1 to 4) {
        var userinput = readInt
        World.movePlayer(Direction.East)
      }
    }
    
  }

}