package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.oi;
import frc.robot.subsystems.WristRollers;

public class WristRollerManual extends CommandBase {
    public WristRollerManual(){
        addRequirements(WristRollers.getInstance());
    }
    public void execute(){
     double output = oi.getInstance().getDriver().getLeftTrigger();
     if(intaking){
         output = 0.3;
     } 
     else if(output>0.5){
         output = -0.3;
     }
     output = 0;
    }
}
