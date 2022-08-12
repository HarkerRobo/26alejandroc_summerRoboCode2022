package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import harkerrobolib.wrappers.HSTalon;

public class Intake extends SubsystemBase{
    
    private static Intake instance;
    private HSTalon motor;
    private static final int MOTER_ID = 0;
    private static final boolean INVERT = false;
    private DoubleSolenoid intake;
    public static final int FORWARD_ID = 0;
    public static final int REVERSE_ID = 0;
    private boolean intaking;
    private Intake(){
        motor = new HSTalon(MOTER_ID);
        motor.setInverted(INVERT);
        intake = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, FORWARD_ID, REVERSE_ID);
    }

    public HSTalon getmotor(){
        return motor;
    }
    public void setoutput(double output){
        if(output > 0.1){
            intaking = true;
        }
        else
        intaking = false;
        motor.set(ControlMode.PercentOutput, output);
    }
    public boolean isIntaking(){
        return intaking;
    }
    public void toggle(){
        if(intake.get() == Value.kForward){
        intake.set(Value.kReverse);
    }
    else{
        intake.set(Value.kForward);
    }
}

    public static Intake getInstance(){
        if(instance == null){
            instance = new Intake();
        }
        return instance;
    }


}
