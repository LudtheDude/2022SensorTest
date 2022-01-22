// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Commands;

import frc.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.util.Color;
import com.revrobotics.ColorMatchResult;

public class DetectColor extends Command{

	Color detectedColor;
	ColorMatchResult match;
	Color target;

	public DetectColor(){
		requires(Robot.colorSensor);
	}

	@Override
	protected void initialize(){
		//target = Robot.colorSensor.kBlueBall; //use depending on the color ball we want
		//target = Robot.colorSensor.kRedBall;
		System.out.println("initialize");

	}

	@Override
	protected void execute(){
		detectedColor = Robot.colorSensor.sensor.getColor();
		//match = Robot.colorSensor.colorMatch.matchClosestColor(detectedColor);
		System.out.println("Detected Color: " + detectedColor);
		//System.out.println(“Match Color: “ + match.color);
		//System.out.println(“Match equals target?:” + match.color == target);

		System.out.println("Distance: " + Robot.colorSensor.sensor.getProximity());
		//if(match.color == target){
			//intake
		//}
		
	}

	@Override
  	protected boolean isFinished() {
		return false;
	}

	@Override
 	protected void end() {
	}

	@Override
  	protected void interrupted() {
	}

}