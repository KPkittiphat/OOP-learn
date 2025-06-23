import java.awt.*;
import java.io.File;
import javax.sound.sampled.*;
import javax.swing.*;

public class MusicApp extends JFrame {

    private DefaultListModel<String> songListModel;
    private JList<String> songList;
    private JButton playButton, pauseButton, stopButton;
    private JLabel currentSongLabel;

    private Clip clip;
    private boolean isPaused = false;
    private int pausePosition = 0;

    public MusicApp() {
        setTitle("Simple Music App");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        songListModel = new DefaultListModel<>();
        // Hardcoded songs - replace with actual file paths or load from folder
        songListModel.addElement("song1.wav");
        songListModel.addElement("song2.wav");
        songListModel.addElement("song3.wav");

        songList = new JList<>(songListModel);
        JScrollPane scrollPane = new JScrollPane(songList);
        add(scrollPane, BorderLayout.CENTER);

        JPanel controlPanel = new JPanel();
        playButton = new JButton("Play");
        pauseButton = new JButton("Pause");
        stopButton = new JButton("Stop");

        controlPanel.add(playButton);
        controlPanel.add(pauseButton);
        controlPanel.add(stopButton);

        add(controlPanel, BorderLayout.SOUTH);

        currentSongLabel = new JLabel("No song playing");
        add(currentSongLabel, BorderLayout.NORTH);

        playButton.addActionListener(e -> playSong());
        pauseButton.addActionListener(e -> pauseSong());
        stopButton.addActionListener(e -> stopSong());
    }

    private void playSong() {
        if (clip != null && clip.isRunning()) {
            return; // already playing
        }
        if (clip != null && isPaused) {
            clip.setFramePosition(pausePosition);
            clip.start();
            isPaused = false;
            currentSongLabel.setText("Playing: " + songList.getSelectedValue());
            return;
        }
        String selectedSong = songList.getSelectedValue();
        if (selectedSong == null) {
            JOptionPane.showMessageDialog(this, "Please select a song to play.");
            return;
        }
        try {
            if (clip != null) {
                clip.close();
            }
            File audioFile = new File(selectedSong);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
            clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();
            currentSongLabel.setText("Playing: " + selectedSong);
            isPaused = false;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error playing the song: " + ex.getMessage());
        }
    }

    private void pauseSong() {
        if (clip != null && clip.isRunning()) {
            pausePosition = clip.getFramePosition();
            clip.stop();
            isPaused = true;
            currentSongLabel.setText("Paused: " + songList.getSelectedValue());
        }
    }

    private void stopSong() {
        if (clip != null) {
            clip.stop();
            clip.close();
            isPaused = false;
            currentSongLabel.setText("Stopped");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MusicApp app = new MusicApp();
            app.setVisible(true);
        });
    }
}
