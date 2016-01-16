package jmri.jmrit.operations.automation.actions;

import jmri.jmrit.operations.routes.RouteLocation;
import jmri.jmrit.operations.trains.Train;

public class MoveTrainAction extends Action {

    private static final int _code = ActionCodes.MOVE_TRAIN;

    @Override
    public int getCode() {
        return _code;
    }

    @Override
    public String toString() {
        return Bundle.getMessage("MoveTrain");
    }

    @Override
    public void doAction() {
        if (getAutomationItem() != null) {
            Train train = getAutomationItem().getTrain();
            if (train != null && train.isBuilt()) {
                RouteLocation rl = getAutomationItem().getRouteLocation();
                if (rl != null) {
                    train.move(rl);
                } else {
                    train.move();
                }
            }
            // now show message if there's one
            finishAction();
        }
    }

    @Override
    public void cancelAction() {
        // no cancel for this action     
    }

}