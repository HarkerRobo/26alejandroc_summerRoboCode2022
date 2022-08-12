package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.oi;
import frc.robot.subsystems.elevator;

public class ElevatorManual extends CommandBase{
    public ElevatorManual(){
        addRequirements(elevator.getinstance());
    }
    public void execute(){
        double output = oi.getInstance().getDriver().getRightY();
        if (Math.abs(output)<0.1){
            output = 0.1;
        }
        elevator.getinstance().setoutput(output);
    }
    public void end(boolean interupted){
        elevator.getinstance().setoutput(0);
    }
}
