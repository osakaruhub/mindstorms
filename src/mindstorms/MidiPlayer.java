import javax.sound.midi.*;
import java.io.File;

public class MidiPlayer {
    public static void main(String[] args) {
        try {
            // Load the MIDI file
            Sequence sequence = MidiSystem.getSequence(new File("track.mid"));
            // Get the tracks from the sequence
            Track[] tracks = sequence.getTracks();

            for (Track track : tracks) {
                for (int i = 0; i < track.size(); i++) {
                    MidiEvent event = track.get(i);
                    MidiMessage message = event.getMessage();

                    // Check if the message is a note on message
                    if (message instanceof ShortMessage) {
                        ShortMessage sm = (ShortMessage) message;
                        if (sm.getCommand() == ShortMessage.NOTE_ON) {
                            int note = sm.getData1(); // Note number
                            int velocity = sm.getData2(); // Velocity
                            long tick = event.getTick(); // Tick position

                            // Convert MIDI note to frequency
                            double frequency = 440.0 * Math.pow(2, (note - 69) / 12.0);
                            // Calculate note duration (in milliseconds)
                            long duration = (long) (60000.0 / (sequence.getResolution() * (tick + 1)));

                            System.out.println(i + ": " + frequency + "for " + duration);
                            // Play the note on EV3
                            //playNoteOnEV3(frequency, duration);
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void playNoteOnEV3(double frequency, long duration) {
        // Use EV3 Sound class to play the note
        //Sound.playTone((int) frequency, (int) duration);
    }
}

