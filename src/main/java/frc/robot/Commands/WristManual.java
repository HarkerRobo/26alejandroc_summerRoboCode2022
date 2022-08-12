package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.oi;
import frc.robot.subsystems.wrist;

public class WristManual extends CommandBase {
    public WristManual(){
        addRequirements(wrist.getInstance());
    }
    public void execute(){
        double output = 0;
        if(oi.getInstance().getDriver().getUpDPadButton().get()){
            output = 0.7;
        }
        else if(oi.getInstance().getDriver().getDownDPadButton().get()){
            output= -0.7;
        }
        else{
            output = 0.2;
        }
        wrist.getInstance().setoutput(output);
    }
    public void end(boolean interrupted){
        wrist.getInstance().setoutput(0);
    }
}
