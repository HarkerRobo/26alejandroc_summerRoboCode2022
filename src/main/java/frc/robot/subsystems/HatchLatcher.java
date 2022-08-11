package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class HatchLatcher extends SubsystemBase{
    private static HatchLatcher instance;
    private DoubleSolenoid flower;
    private DoubleSolenoid extender;
    private static final int FLOWER_ID = 0;
    private static final int FLOWERREVERSE_ID = 0;
    private static final int EXTENDER_ID = 0;
    private static final int EXTENDERREVERSE_ID = 0;

    private HatchLatcher(){
        flower = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, FLOWER_ID, FLOWERREVERSE_ID);
        flower = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, EXTENDER_ID, EXTENDERREVERSE_ID);
    }
    public void toggleFlower(){
        if(flower.get() == Value.kForward){
            flower.set(Value.kReverse);
        }
        else{
            flower.set(Value.kForward);
        }
    }
    public void toggleExtender(){
        if(extender.get() == Value.kForward){
            flower.set(Value.kReverse);
        }
        else{
            flower.set(Value.kReverse);
        }
    }
    public DoubleSolenoid getFlower(){
        return flower;
    }
    public DoubleSolenoid getExtender(){
        return extender;
    }
    public static HatchLatcher getinstance(){
        if(instance == null){
            instance = new HatchLatcher();
        }
        return instance;
    }
}
