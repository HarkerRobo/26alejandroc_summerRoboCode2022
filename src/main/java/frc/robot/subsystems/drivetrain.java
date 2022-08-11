package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import harkerrobolib.wrappers.HSTalon;

public class drivetrain extends SubsystemBase {
    private static drivetrain instance;
    private HSTalon rightmaster;
    private HSTalon leftmaster;
    private VictorSPX rightfollow;
    private VictorSPX leftfollow;

    private static final boolean RIGHTMASTERINVERT = false;
    private static final boolean LEFTMASTERINVERT = false;
    private static final boolean RIGHTFOLLOWINVERT = false;
    private static final boolean LEFTFOLLOWINVERT = false;

    private static final int RIGHTMASTERID = 0;
    private static final int LEFTMASTERID = 0;
    private static final int RIGHTFOLLOWID = 0;
    private static final int LEFTFOLLOWID = 0;
    public drivetrain(){
        rightmaster = new HSTalon(RIGHTMASTERID);
        leftmaster = new HSTalon(LEFTMASTERID);
        rightfollow= new VictorSPX(RIGHTFOLLOWID);
        leftfollow= new VictorSPX(LEFTFOLLOWID);
        rightfollow.follow(rightmaster);
        leftfollow.follow(leftmaster);
        rightmaster.setInverted(RIGHTMASTERINVERT);
        leftmaster.setInverted(LEFTMASTERINVERT);
        leftfollow.setInverted(LEFTFOLLOWINVERT);
        rightfollow.setInverted(RIGHTFOLLOWINVERT);
    }
    public void setArcadeDrive(double speed, double turn){
        rightmaster.set(ControlMode.PercentOutput,speed-turn);
        leftmaster.set(ControlMode.PercentOutput,speed+turn);
    }
    public static drivetrain getInstance(){
        if (instance == null){
            instance = new drivetrain();
        }
        return instance;
    }

}
