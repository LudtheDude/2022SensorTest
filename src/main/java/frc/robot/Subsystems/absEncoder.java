// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.Commands.encoMand;

/** Add your docs here. */
public class absEncoder extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  public static Encoder encoder1 = new Encoder(RobotMap.encoderPort1, RobotMap.encoderPort2);
  public static CANSparkMax motor = new CANSparkMax(RobotMap.motorPort, MotorType.kBrushless);

  public static double returnDistance(){
    motor.set(0.1);
    return encoder1.getDistance();
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new encoMand());
  }
}
