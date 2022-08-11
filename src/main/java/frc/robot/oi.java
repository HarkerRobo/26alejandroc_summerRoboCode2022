package frc.robot;

import harkerrobolib.wrappers.HSGamepad;
import harkerrobolib.wrappers.XboxGamepad;

public class oi {
    private static oi instance;
    private HSGamepad driver;
    private HSGamepad operator;
    private static final int DRIVER_ID=0;
    private static final int OPERATOR_ID=0;

    public oi(){
        driver = new XboxGamepad(DRIVER_ID);
        operator = new XboxGamepad(OPERATOR_ID);
        
    }
    public void initBindings(){
        //driver.getButtonA().whilePressed(new)
    }
    public HSGamepad getDriver(){
    return driver;
    }
    public HSGamepad getOperator(){
    return operator;
    }
    public static oi getInstance(){

        if (instance == null){
            instance = new oi();
        }
        return instance;
    }
}
