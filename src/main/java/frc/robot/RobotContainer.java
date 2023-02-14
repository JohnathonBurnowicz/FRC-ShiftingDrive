// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.PS4Controller.Button;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.DriveForwardTimed;
import frc.robot.commands.ShiftingDrive;
import frc.robot.commands.PneumaticsCommand;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.PneumaticSub;
import frc.robot.subsystems.PneumaticSub2;
import frc.robot.commands.PneumaticsCommand2;
import frc.robot.subsystems.PneumaticSub3;
import frc.robot.commands.PneumaticsCommand3;
import frc.robot.commands.ShiftingDrive;
//import frc.robot.subsystems.ShooterSubsystem;
//import frc.robot.commands.ShootWithButton;
/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
 
  // DriveTrain Declare
  private final DriveTrain driveTrain;

  private final ShiftingDrive driveWithJoysticks;
  private final DriveForwardTimed driveForardTimed;
private final PneumaticSub pneumaticSub = new PneumaticSub();
private final PneumaticSub2 pneumaticSub2 = new PneumaticSub2();
private final PneumaticSub3 pneumaticSub3 = new PneumaticSub3();

//shooter declare
//private final ShooterSubsystem shooterSubsystem;



public static XboxController driverJoystick;

/** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
//Driver commands
    driveTrain = new DriveTrain();
    driveWithJoysticks = new ShiftingDrive(driveTrain);
    driveWithJoysticks.addRequirements(driveTrain);
    driveTrain.setDefaultCommand(driveWithJoysticks);

    driveForardTimed = new DriveForwardTimed(driveTrain);
    driveForardTimed.addRequirements(driveTrain);

    driverJoystick = new XboxController(Constants.DRIVER_JOYSTICK_PORT);
    
 




  //  shooterSubsystem = new ShooterSubsystem();
    

    // Configure the button bindings
    configureButtonBindings();
    
    //Pneumatic button bindings
    JoystickButton DriverAButton = new JoystickButton(driverJoystick, Constants.XBOX_A_BUTTON);
   // JoystickButton DriverBButton = new JoystickButton(driverJoystick, Constants.XBOX_B_BUTTON);
DriverAButton.whenPressed(new PneumaticsCommand(pneumaticSub));
  
JoystickButton DriverBButton = new JoystickButton(driverJoystick, Constants.XBOX_B_BUTTON);
   // JoystickButton DriverBButton = new JoystickButton(driverJoystick, Constants.XBOX_B_BUTTON);
DriverBButton.whenPressed(new PneumaticsCommand2(pneumaticSub2));

JoystickButton DriverXButton = new JoystickButton(driverJoystick, Constants.XBOX_X_BUTTON);
   // JoystickButton DriverBButton = new JoystickButton(driverJoystick, Constants.XBOX_B_BUTTON);
DriverXButton.whenPressed(new PneumaticsCommand3(pneumaticSub3));

//shooter button binding
/*JoystickButton DriverYButton = new JoystickButton(driverJoystick, Constants.XBOX_Y_BUTTON);
   // JoystickButton DriverBButton = new JoystickButton(driverJoystick, Constants.XBOX_B_BUTTON);
DriverYButton.whenPressed(new ShootWithButton(shooterSubsystem));
*/

}

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    

  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return driveForardTimed;
  }
}