// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import frc.robot.RobotMap;
import frc.robot.Commands.driveAlign;

/** Add your docs here. */
public class Drive extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  //public static CANSparkMax shooterMotor = new CANSparkMax(RobotMap.shooterMotorPort, MotorType.kBrushless);
	//public static DutyCycleEncoder shooterEncoder = new DutyCycleEncoder(RobotMap.dcEncoder);
	//public static DoubleSolenoid shooterPiston = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, RobotMap.shooterPistonForwardPort, RobotMap.shooterPistonBackwardPort);
	//public static double windDistance; // distance to wind string
	public static double distance = 20.0;
	public static double lowerBound = 2;
	public static double upperBound = 5;
	public static Limelight limelight;

	//import from drivetrain
	public static CANSparkMax frontRight = new CANSparkMax(RobotMap.frontRightPort, MotorType.kBrushless);
	public static CANSparkMax rearRight = new CANSparkMax(RobotMap.rearRightPort, MotorType.kBrushless);
	public static CANSparkMax frontLeft = new CANSparkMax(RobotMap.frontLeftPort, MotorType.kBrushless);
	public static CANSparkMax rearLeft = new CANSparkMax(RobotMap.rearLeftPort, MotorType.kBrushless);
	public static CANSparkMax midRight = new CANSparkMax(RobotMap.midRightPort, MotorType.kBrushless);
	public static CANSparkMax midLeft = new CANSparkMax(RobotMap.midLeftPort, MotorType.kBrushless);
	//public static MecanumDrive mecanum = new MecanumDrive(frontLeft, rearLeft, frontRight, rearRight);
	//public static AnalogGyro gyro = new AnalogGyro(RobotMap.gyroPort); 

	 //PID fields
	//  public final static double Kp1 = 0.01;
	//  public final static double Ki1 = 0.0;
	//  public final static double Kd1 = 0.0;
	//  //public double distance, left_speed, right_speed;
	//  public double left_speed1, right_speed1;
	//  static double min_error1 = 0.1; //sets an error deadband/ minimum value
	//  static double min_command1 = 0.0;
	//  static double current_error1 = 0; 
	//  static double previous_error1 = 0;
	//  static double integral1 = 0;
	//  static double derivative1 = 0;
	//  static double adjust1 = 0;
	//  static double time1 = 0.1; // 0.1 seconds = 100 milliseconds 
	 
	 public final static double Kp2 = 0.1;
	 public final static double Ki2 = 0.0;
	 public final static double Kd2 = 0.0;
	 //public double distance, left_speed, right_speed;
	 public double left_speed2, right_speed2;
	 static double min_error2 = 0.1; //sets an error deadband/ minimum value
	 static double min_command2 = 0.0;
	 static double current_error2 = 0; 
	 static double previous_error2 = 0;
	 static double integral2 = 0;
	 static double derivative2 = 0;
	 static double adjust2 = 0;
	 static double time2 = 0.1; // 0.1 seconds = 100 milliseconds

  	public Drive(){
	}
// this is a really cool code. please don't kill the robot. - Kathryn Le (2004-infinity)
// this is a concise code. Kathryn will make it shorter soon. Please stand by. - pi 
// is this like a google doc where you can make comments and resolve them? - Jillian, Co-Head of Programming of the Fe Maidens
// 
	public void stopDrive(){
		frontLeft.set(0.0);
		rearLeft.set(0.0);
		frontRight.set(0.0);
		rearRight.set(0.0);
	}

	public void driveStraight(double speed, double adjust){
		frontRight.set(-1*(speed - adjust*0.01));
		midRight.set(-1*(speed - adjust*0.01));
		rearRight.set(-1*(speed - adjust*0.01));
		frontLeft.set(speed + adjust*0.01);
		midLeft.set(speed + adjust*0.01);
		rearLeft.set(speed + adjust*0.01);
	  }

	public void alignDrive(){
		//while(Limelight.getDistance() != distance){
			// previous_error1 = current_error1;
			// current_error1 = distance - Limelight.getDistance();
			// integral1 = (current_error1+previous_error1)/2*(time1);
			// derivative1 = (current_error1-previous_error1)/time1;
			// adjust1 = Kp1*current_error1 + Ki1*integral1 + Kd1*derivative1;
	  
			// if (current_error1 > min_error1){
			//   adjust1 += min_command1;
			// }
			// else if (current_error1 < -min_error1){
			//   adjust1 -= min_command1;
			// }

			// if (Limelight.getDistance() > distance){
			// 	mecanum.driveCartesian(0, 0.3 + adjust1, 0);
			// }

			// else if (Limelight.getDistance() < distance){
			// 	mecanum.driveCartesian(0, 0.3 - adjust1, 0);
			// }
		//}
		while(Limelight.getTX() != 0){
			previous_error2 = current_error2;
			current_error2 = Limelight.getTX();
			integral2 = (current_error2+previous_error2)/2*(time2);
			derivative2 = (current_error2-previous_error2)/time2;
			adjust2 = Kp2*current_error2 + Ki2*integral2 + Kd2*derivative2;
	  
			if (current_error2 > min_error2){
			  adjust2 += min_command2;
			}
			else if (current_error2 < -min_error2){
			  adjust2 -= min_command2;
			}

			driveStraight(.1, adjust2);
		}
		stopDrive();
	}

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
	setDefaultCommand(new driveAlign());
  }
}