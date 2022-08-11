package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.subsystems.HatchLatcher;

public class ToggleExtender extends InstantCommand {
    public ToggleExtender(){
        addRequirements(HatchLatcher.getinstance());
    }
    public void initalize(){
        HatchLatcher.getinstance().toggleExtender();
    }    
}
