package mindstorms;

import javax.sound.midi.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class MidiPCPlayer {

    private static float BPM = 120; // Beats per minute
    private static int PPQ = 480; // Pulses per quarter note (common value)
    private static File f;
    private static BufferedWriter writer;
    private static final String seperator = System.lineSeparator();

    public static void main(String[] args) {
    	extractSong();
    }
    
    public static void extractSong() {
    	try {
            Sequencer sequencer = MidiSystem.getSequencer();
            if (sequencer == null) {
                System.out.println("No sequencer available.");
                return;
            }

            sequencer.open();
            Sequence sequence = MidiSystem.getSequence(new File("midi/elise.mid"));
            //BPM = getBPM(sequence);
            System.out.println(BPM);
            PPQ = sequence.getResolution();
            System.out.println(PPQ);
            sequencer.setSequence(sequence);
            sequencer.start();
            
        	f = new File("elise.aev");
        	writer = new BufferedWriter(new FileWriter(f));

            Track[] tracks = sequence.getTracks();
            for (Track track : tracks) {
                extractNotes(track);
            }
            writer.flush();
            writer.close();
            sequencer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

public static float getBPM(Sequence sequence) {
        for (Track track : sequence.getTracks()) {
            for (int i = 0; i < track.size(); i++) {
                MidiEvent event = track.get(i);
                MidiMessage message = event.getMessage();

                // Check if the message is a MetaMessage
                if (message instanceof MetaMessage) {
                    MetaMessage metaMessage = (MetaMessage) message;
                    // Check for the Set Tempo message (0x51)
                    if (metaMessage.getType() == 0x51) {
                        byte[] data = metaMessage.getData();
                        // The tempo is stored in the first three bytes
                        int microsecondsPerQuarterNote = ((data[0] & 0xFF) << 16) | ((data[1] & 0xFF) << 8) | (data[2] & 0xFF);
                        // Calculate BPM
                        return 60000000f / microsecondsPerQuarterNote;
                    }
                }
            }
        }
        // Return a default BPM if no tempo event is found
        return 120; // Default BPM
    }

    private static void extractNotes(Track track) {
        long lastNoteOnTime = -1;
        int lastNote = -1;

        for (int i = 0; i < track.size(); i++) {
            MidiEvent event = track.get(i);
            MidiMessage message = event.getMessage();

            if (message instanceof ShortMessage) {
                ShortMessage sm = (ShortMessage) message;

                // Check for NOTE_ON message
                if (sm.getCommand() == ShortMessage.NOTE_ON) {
                    lastNoteOnTime = event.getTick();
                    lastNote = sm.getData1();
                    System.out.println("Note ON: " + lastNote + " at tick " + lastNoteOnTime);
                }
                
                // Check for NOTE_OFF message
                if (sm.getCommand() == ShortMessage.NOTE_OFF) {
                    if (lastNote != -1) {
                        long noteDurationTicks = event.getTick() - lastNoteOnTime;
                        double frequency = midiToFrequency(lastNote);
                        double durationInSeconds = ticksToSeconds(noteDurationTicks);
                        System.out.printf("Note OFF: %d at tick %d, Frequency: %.2f Hz, Duration: %.3f seconds%n",
                                          lastNote, event.getTick(), frequency, durationInSeconds);
                        try {
							writer.append((frequency + " " + durationInSeconds));
							writer.newLine();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
                        // Play the frequency
                        //robot.playtune(frequency, duration);
                        lastNote = -1;  // Reset lastNote after processing
                    }
                }
            }
        }
    }

    private static double midiToFrequency(int midiNote) {
        return (int) 440.0 * Math.pow(2, (midiNote - 69) / 12.0);
    }

    private static double ticksToSeconds(long ticks) {
        double secondsPerBeat = 60.0 / BPM;
        return (int) ticks * secondsPerBeat / PPQ;
    }

}
