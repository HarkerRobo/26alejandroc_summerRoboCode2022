package frc.robot.Commands;

import frc.robot.oi;

import frc.robot.subsystems.drivetrain;
import harkerrobolib.commands.IndefiniteCommand;

public class ArcadeDrive extends IndefiniteCommand{
    private double turn;
    private double drive;
    
    public ArcadeDrive(){
        addRequirements(drivetrain.getInstance());
    }
public void initialize(){

}
    public void execute(){
        drive = oi.getInstance().getDriver().getLeftY();
        turn = oi.getInstance().getDriver().getLeftX();
        drivetrain.getInstance().setArcadeDrive(drive, turn);
    }
    public void end(boolean interrupted){
        drive = 0;
        turn = 0;
        drivetrain.getInstance().setArcadeDrive(drive, turn);
    }

}

