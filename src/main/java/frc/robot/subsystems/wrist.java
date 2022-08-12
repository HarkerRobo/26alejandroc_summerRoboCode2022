package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import harkerrobolib.wrappers.HSTalon;

public class wrist extends SubsystemBase{
    private static wrist instance;
    private HSTalon master;
    private VictorSPX follow;
    private static final int MASTER_ID = 0;
    private static final boolean MASTER_INVERT = false;
    private static final int FOLLOW_ID = 0;
    private static final boolean FOLLOW_INVERT = false;
    public wrist(){
        master = new HSTalon(MASTER_ID);
        follow = new VictorSPX(FOLLOW_ID);
        master.setInverted(MASTER_INVERT);
        follow.setInverted(FOLLOW_INVERT);
        follow.follow(master);
    }
    public void setoutput(double output){
        master.set(ControlMode.PercentOutput, output);
    }

    public static wrist getInstance(){
        if(instance == null){
            instance = new wrist();
        }
        return instance;
    }
}
