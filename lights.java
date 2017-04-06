package midterm.practice;


import javafx.animation.* ;
import javafx.util.Duration;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;


public class lights extends Application
{
   public void start( Stage stage )
   {
      Group group_for_ball = new Group() ;

      stage.setTitle( "AnimationDemoFX.java" ) ;

      Scene scene = new Scene( group_for_ball, 600, 500 ) ;

      scene.setFill( Color.LIGHTYELLOW ) ;

      Circle blinking_ball = new Circle( 300, 250, 64, Color.WHITE ) ;

      group_for_ball.getChildren().add( blinking_ball ) ;
           
      stage.setScene( scene ) ;
      stage.show() ;

      Timeline timeline = new Timeline() ;

      timeline.setCycleCount( Animation.INDEFINITE ) ;

      // The following EventHandler specifies what will be done
      // after the animation specified by the KeyFrame is finished.
      // The arrow token -> identifies a Lambda expression.

      EventHandler<ActionEvent> on_finished = ( ActionEvent event ) ->
      {
         if ( blinking_ball.getFill() == Color.WHITE )
         {
            blinking_ball.setFill( Color.TRANSPARENT ) ;
         }
         else
         {
            blinking_ball.setFill( Color.WHITE) ;
         }

         System.out.print( "\n on_finished executed. " ) ;
      } ;

      // Next we specify a KeyFrame whose execution takes 1 second.
      // The EventHandler will be executed after that.
      // No actual modification of values is specified by this KeyFrame.
      // This can thus be considered a misuse of a KeyFrame.

      KeyFrame keyframe = new KeyFrame( Duration.millis( 1000 ),
                                        on_finished ) ;

      timeline.getKeyFrames().add( keyframe ) ;

      timeline.play() ;
   }

   public static void main( String[] command_line_parameters )
   {
      launch( command_line_parameters ) ;
   }
}


