// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Commands.*;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/** Add your docs here. */
public class OI{
    
	public static Joystick driveJoy = new Joystick(RobotMap.driveJoyPort);
	public static Button color = new JoystickButton(driveJoy, 3);

	public void bindButtons(){
		color.whileHeld(new DetectColor()); 
	}
}

