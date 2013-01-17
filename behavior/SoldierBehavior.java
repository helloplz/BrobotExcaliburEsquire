package behavior;

import battlecode.common.MapLocation;
import battlecode.common.RobotController;
import behavior.RobotBehavior;

public class SoldierBehavior extends RobotBehavior {
    public void moveTo(RobotController rc, MapLocation loc) {
        
        Direction roboDir = rc.getLocation().directionTo(loc);
        Location mineLoc = loc.add(roboDir, 1);
        Team mineTeam = rc.senseMine(mineLoc);
        Location backUpLoc = rc.getLocation().
        
        if (mineTeam = rc.getTeam() || mineTeam = null){
            isEnemyMine = false;
        }
        if (mineTeam != null && mineTeam != rc.getTeam()){
            isEnemyMine = true;
        }
        
        if(isEnemyMine){
            rc.defuseMine(mineLoc));
        }
        if(rc.canMove(roboDir) && !isEnemyMine){
            rc.move(roboDir);
        }
        else{
            moveTo(rc,loc.add(0,1) );
        }
    }

    @Override
    public void run(RobotController rc) {

    }
}
