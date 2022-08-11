package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.subsystems.HatchLatcher;

public class ToggleFlower extends InstantCommand {
    public ToggleFlower(){
        addRequirements(HatchLatcher.getinstance());
    }
    public void initalize(){
        HatchLatcher.getinstance().toggleFlower();
    }    
}
