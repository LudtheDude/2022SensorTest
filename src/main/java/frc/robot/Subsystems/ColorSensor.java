// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems;


import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Commands.DetectColor;

import com.revrobotics.ColorSensorV3;

import com.revrobotics.ColorMatch;


public class ColorSensor extends Subsystem{

	private final I2C.Port i2cPort = I2C.Port.kOnboard;
	public ColorSensorV3 sensor = new ColorSensorV3(i2cPort);
	public final ColorMatch colorMatch = new ColorMatch();
	//private final Color kBlueBall = ColorMatch.makeColor(0.143, 0.427, 0.429); //test for values
	//private final Color kRedBall = ColorMatch.makeColor(0.561, 0.232, 0.114); // test for values
	private static int distance;

	public ColorSensor(){
		//colorMatch.addColorMatch(kBlueBall);
		//colorMatch.addColorMatch(kRedBall);

	}

	public int getDistance(){
		distance = sensor.getProximity();
		return distance;
	}

	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new DetectColor());

	}

}