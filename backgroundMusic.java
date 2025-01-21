import javax.sound.sampled.*;
import java.io.File;

/**
 * This class is the backgroundMusic class and it provides the functionality to play background audio
 * for the game. It supports looping the audio indefinitely and adjusting
 * the volume.
 * 
 * <p>This class is part of the Petopia project.</p>
 * 
 * @author group 34
 * @version 1.0
 * @since 2024-12-03
 */
public class backgroundMusic {

    /**
     * This plays a background audio track in a loop. This method loads an audio file,
     * configures the playback volume, and loops the track.
     * 
     * <p>The method uses the Java Sound API to handle audio playback. The audio
     * file must be located at "sounds/backgroundSound.wav" which is relative to the
     * project's root directory.</p>
     * 
     * <p><b>Note:</b> This method runs indefinitely, so it is recommended to
     * integrate it into a separate thread when used in a GUI application.</p>
     */
    public static void playSong() {
        try {
            // this loads the audio file
            File audioFile = new File("sounds/backgroundSound.wav");
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);

            // this creates a clip for playback
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);

            // this is optional but it sets the volume 
            FloatControl volumeControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            volumeControl.setValue(-10.0f); // this adjusts the volume level in decibels

            // this loops the audio indefinitely
            clip.loop(Clip.LOOP_CONTINUOUSLY);

            // this starts playing the audio
            clip.start();
            System.out.println("Playing audio...");

            // this keeps the program running indefinitely
            while (true) {
                Thread.sleep(1000); // this causes the audio to 'sleep' so that it reduces the CPU usage
            }
        } catch (Exception e) {
            // this prints the stack trace (for debugging purposes)
            e.printStackTrace();
        }
    }

    /**
     * this is the main method that serves as the entry point for the application.
     * It starts the playback of the background music.
     * 
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        playSong();
    }
}
