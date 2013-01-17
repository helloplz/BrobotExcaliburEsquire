package team238.behavior;

import battlecode.common.Direction;
import battlecode.common.GameActionException;
import battlecode.common.RobotController;

public class HQBehavior extends RobotBehavior {

  @Override
  public void run(RobotController rc) {
    try {
      if (rc.isActive()) {
        Direction dir = rc.getLocation().directionTo(rc.senseEnemyHQLocation());
        if (rc.canMove(dir)) {
          rc.spawn(dir);
        }
        else {
          Direction[] dirs = {Direction.NORTH, Direction.NORTH_EAST, Direction.EAST, Direction.SOUTH_EAST, Direction.SOUTH, Direction.SOUTH_WEST, Direction.WEST, Direction.NORTH_WEST};
          int i;
          for (i = 0; i < dirs.length; i++) {
            dir = dirs[i];
            if (rc.canMove(dir)) {
              rc.spawn(dir);
              break;
            }
          }
        }
      }
    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }
}
