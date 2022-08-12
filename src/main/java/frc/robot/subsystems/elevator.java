package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import harkerrobolib.wrappers.HSTalon;

public class elevator extends SubsystemBase{
    private static elevator instance;

    private HSTalon master;
    private HSTalon follow;
    private VictorSPX followm;
    private VictorSPX followf;
    public static final int MASTER_ID = 0;
    public static final int FOLLOW_ID = 0;
    public static final int FOLLOWM_ID = 0;
    public static final int FOLLOWF_ID = 0;
    public static final boolean MASTER_INVERT = false;
    public static final boolean FOLLOW_INVERT = false;
    public static final boolean FOLLOWM_INVERT = false;
    public static final boolean FOLLOWF_INVERT = false;

    private elevator(){
        master = new HSTalon(MASTER_ID);
        follow = new HSTalon(FOLLOW_ID);
        followm = new VictorSPX(FOLLOWM_ID);
        followf = new VictorSPX(FOLLOWF_ID);
        master.setInverted(MASTER_INVERT);
        follow.setInverted(FOLLOW_INVERT);
        followm.setInverted(FOLLOWM_INVERT);
        followf.setInverted(FOLLOWF_INVERT);
        follow.follow(master);
        followf.follow(follow);
        followm.follow(master);
    }
    public void setoutput(double output){
        master.set(ControlMode.PercentOutput, output);
    }
    public static elevator getinstance(){
        if(instance == null){
            instance = new elevator();
        }
        return instance;
    }
}