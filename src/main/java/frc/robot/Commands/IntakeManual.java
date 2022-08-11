package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.oi;
import frc.robot.subsystems.Intake;

public class IntakeManual extends CommandBase{
    public IntakeManual(){
        addRequirements(Intake.getInstance());
    }
    public void inicalize(){
        Intake.getInstance().toggle();
        
    }
    public void execute(){
        double output = oi.getInstance().getDriver().getRightTrigger();
       if(output>0.5){
           output = 0.3;
       }
       else{
           output = 0;
       }
       Intake.getInstance().setoutput(output);
    }
    public void end(boolean interupted){
        Intake.getInstance().setoutput(0);
    }
}
