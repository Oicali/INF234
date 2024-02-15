/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package settings;

import java.io.*;
import javax.sound.sampled.*;

public class sounds {

    // Global variables 
    static float value;
    static Clip clip, clip1, clip2, clip3, clip4;

    // Sound methods
    public static void playOpening() {
        File file = new File("C:\\Users\\jairus\\Documents\\GitHub\\ATM\\BIT_ATM\\src\\ATM_resources\\Intro_sound.wav");

        try {
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
            clip = AudioSystem.getClip();
            clip.open(audioStream);

            clip.start();
        } catch (UnsupportedAudioFileException | IOException e) {
            e.printStackTrace(); // Or handle the exception in a way that makes sense for your application
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    public static void playError() {
        
            File file1 = new File("C:\\Users\\jairus\\Documents\\GitHub\\INF234\\FinalProject_ATM\\src\\main\\java\\resources\\error.wav");
            try {
                AudioInputStream audioStream = AudioSystem.getAudioInputStream(file1);
                clip1 = AudioSystem.getClip();
                clip1.open(audioStream);

                clip1.start();
            } catch (UnsupportedAudioFileException | IOException error) {
                error.printStackTrace(); // Or handle the exception in a way that makes sense for your
                // application
            } catch (LineUnavailableException error) {
                error.printStackTrace();
            }
        
    }

    public static void playWarning() {
        
            File file2 = new File("C:\\Users\\jairus\\Documents\\GitHub\\INF234\\FinalProject_ATM\\src\\main\\java\\resources\\warning.wav");

            try {
                AudioInputStream audioStream = AudioSystem.getAudioInputStream(file2);
                clip2 = AudioSystem.getClip();
                clip2.open(audioStream);
                clip2.start();
            } catch (UnsupportedAudioFileException | IOException error) {
                error.printStackTrace(); // Or handle the exception in a way that makes sense for your application
            } catch (LineUnavailableException error) {
                error.printStackTrace();
            }
        
    }

    public static void playConfirm() {
        
            File file3 = new File("C:\\Users\\jairus\\Documents\\GitHub\\INF234\\FinalProject_ATM\\src\\main\\java\\resources\\confirm.wav");

            try {
                AudioInputStream audioStream = AudioSystem.getAudioInputStream(file3);
                clip3 = AudioSystem.getClip();
                clip3.open(audioStream);
                clip3.start();
            } catch (UnsupportedAudioFileException | IOException error) {
                error.printStackTrace(); // Or handle the exception in a way that makes sense for your application
            } catch (LineUnavailableException error) {
                error.printStackTrace();
            }
        
    }

    public static void playClick() {
        
            File file = new File("C:\\Users\\jairus\\Documents\\GitHub\\INF234\\FinalProject_ATM\\src\\main\\java\\resources\\click.wav");

            try {
                AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
                clip4 = AudioSystem.getClip();
                clip4.open(audioStream);
                clip4.start();
            } catch (UnsupportedAudioFileException | IOException e) {
                e.printStackTrace(); // Or handle the exception in a way that makes sense for your application
            } catch (LineUnavailableException e) {
                e.printStackTrace();
            }
        }
    

}
