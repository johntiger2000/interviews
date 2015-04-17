package jun.dungeon

object Main {

  def main(args: Array[String]): Unit = {
    
    println("World created.")
    var step = 0
    while (true) {
      step += 1
      step % 5 match {
        case 0 => {
            println("Dragon move")
            println("== invisible to player == dragon is %s".format(World.dragon toString))
            World.moveDragon
            println("You are %s".format(World.player toString))
            println("== invisible to player == dragon is %s".format(World.dragon toString))
        }
        case _ => {
            println("You are %s".format(World.player toString))
            println("== invisible to player == dragon is %s".format(World.dragon toString))
            print("Input next move: ")
            while (!World.movePlayer(Direction(readInt))) {
              print("Invalid move. Try again")
            }
            println("You are %s".format(World.player toString))
            println("== invisible to player == dragon is %s".format(World.dragon toString))
            if (World.player.gem >= 5) {
              println("YOU WIN!!!")
              return
            }
        }
      }
    }
    
  }

}