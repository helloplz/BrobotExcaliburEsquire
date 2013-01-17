package team238.behavior;

import battlecode.common.Direction;
import battlecode.common.GameActionException;
import battlecode.common.MapLocation;
import battlecode.common.RobotController;
import battlecode.common.Team;
import team238.behavior.RobotBehavior;

public class SoldierBehavior extends RobotBehavior {
    public void moveTo(RobotController rc, MapLocation loc) {
        
        Direction roboDir = rc.getLocation().directionTo(loc);
        MapLocation mineLoc = loc.add(roboDir, 1);
        Team mineTeam = rc.senseMine(mineLoc);
        MapLocation backUpLoc = rc.getLocation();

        boolean isEnemyMine = false;
        if (mineTeam != null && mineTeam != rc.getTeam()){
            isEnemyMine = true;
        }
        
        if (isEnemyMine) {
            try {
              rc.defuseMine(mineLoc);
            }
            catch (GameActionException e) {
              // TODO Auto-generated catch block
              e.printStackTrace();
            }
        }
        if (rc.canMove(roboDir) && !isEnemyMine) {
            try {
              rc.move(roboDir);
            }
            catch (GameActionException e) {
              // TODO Auto-generated catch block
              e.printStackTrace();
            }
        }
        else {
            moveTo(rc, loc.add(0,1));
        }
    }

    @Override
    public void run(RobotController rc) {

    }
}
