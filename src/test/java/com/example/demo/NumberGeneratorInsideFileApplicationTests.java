package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

@SpringBootTest
class NumberGeneratorInsideFileApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	public void Reading_file()
			throws IOException {
		String expected_value = "900, 895, 890, 885, 880, 875, 870, 865, 860, 855, 850, 845, 840, 835, 830, 825, 820, 815, 810, 805, 800, 795, 790, 785, 780, 775, 770, 765, 760, 755, 750, 745, 740, 735, 730, 725, 720, 715, 710, 705, 700, 695, 690, 685, 680, 675, 670, 665, 660, 655, 650, 645, 640, 635, 630, 625, 620, 615, 610, 605, 600, 595, 590, 585, 580, 575, 570, 565, 560, 555, 550, 545, 540, 535, 530, 525, 520, 515, 510, 505, 500, 495, 490, 485, 480, 475, 470, 465, 460, 455, 450, 445, 440, 435, 430, 425, 420, 415, 410, 405, 400, 395, 390, 385, 380, 375, 370, 365, 360, 355, 350, 345, 340, 335, 330, 325, 320, 315, 310, 305, 300, 295, 290, 285, 280, 275, 270, 265, 260, 255, 250, 245, 240, 235, 230, 225, 220, 215, 210, 205, 200, 195, 190, 185, 180, 175, 170, 165, 160, 155, 150, 145, 140, 135, 130, 125, 120, 115, 110, 105, 100, 95, 90, 85, 80, 75, 70, 65, 60, 55, 50, 45, 40, 35, 30, 25, 20, 15, 10, 5, 0";
		String file ="D:\\9def1986-d818-44db-8f92-bfc3685e5cfe_output.txt";

		BufferedReader reader = new BufferedReader(new FileReader(file));
		String currentLine = reader.readLine();
		reader.close();
		assertEquals(expected_value, currentLine);
	}

}
