import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingWindow extends JFrame {
	private static final int WIDTH = 230;
	private static final int HEIGHT = 350;
	private int gameMode;
	private int fieldSize;
	private int victoryLength;

	JButton btnStart;

	SettingWindow(GameWindow gameWindow) {
		btnStart = new JButton("Start new game");

		setLocationRelativeTo(gameWindow);
		setSize(WIDTH, HEIGHT);

		btnStart.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				gameWindow.startNewGame(gameMode, fieldSize, fieldSize, victoryLength);
			}
		});
		add(createMainPanel());
		add(btnStart, BorderLayout.SOUTH);
	}

	public JPanel createModePanel() {
		JPanel jPanel = new JPanel(new GridLayout(3, 1));
		JLabel jl = new JLabel("Выберите режим игры");
		JRadioButton rb1 = new JRadioButton("Человек против компьютера");
		JRadioButton rb2 = new JRadioButton("Человек против человека");
		ButtonGroup bg = new ButtonGroup();
		rb1.setSelected(true);
		rb1.addActionListener(e -> {
			gameMode = 0;
		});
		rb2.addActionListener(e -> {
			gameMode = 1;
		});
		bg.add(rb1);
		bg.add(rb2);
		jPanel.add(jl);
		jPanel.add(rb1);
		jPanel.add(rb2);
		return jPanel;
	}

	public JPanel createFieldPanel() {
		JPanel jPanel = new JPanel(new GridLayout(3, 1));
		JLabel jl = new JLabel("Выберите размеры поля");
		JSlider jSlider = new JSlider(3, 10, 3);
		JLabel jl2 = new JLabel(String.format("Установленный размер поля %d", jSlider.getValue()));
		jSlider.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				jl2.setText(String.format("Установленный размер поля %d", jSlider.getValue()));
				fieldSize = jSlider.getValue();
			}
		});
		jPanel.add(jl);
		jPanel.add(jl2);
		jPanel.add(jSlider);
		return jPanel;
	}

	public JPanel createVictoryPanel() {
		JPanel jPanel = new JPanel(new GridLayout(3, 1));
		JLabel jl = new JLabel("Выберите длину для победы");
		JSlider jSlider = new JSlider(3, 10, 3);
		JLabel jl2 = new JLabel(String.format("Установленная длина %d", jSlider.getValue()));
		jSlider.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				victoryLength = jSlider.getValue();
				if (victoryLength > fieldSize) {
					victoryLength = fieldSize;
					jSlider.setValue(victoryLength);
				}
				jl2.setText(String.format("Установленная длина %d", jSlider.getValue()));
			}
		});
		jPanel.add(jl);
		jPanel.add(jl2);
		jPanel.add(jSlider);
		return jPanel;
	}

	public JPanel createMainPanel() {
		JPanel jPanel = new JPanel(new GridLayout(3, 1));
		jPanel.add(createModePanel());
		jPanel.add(createFieldPanel());
		jPanel.add(createVictoryPanel());
		return jPanel;
	}

}