package utilities;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Utilities {
	private static ArrayList<Integer> nums = new ArrayList<Integer>();
	private static float r = 0.35f;
	private static float b = 0.75f;
	private static float r2 = 0.35f;
	private static float g2 = 0.55f;
	private static float b2 = 0.75f;
	private static boolean rFlip = false;
	private static boolean bFlip = false;
	private static boolean r2Flip = false;
	private static boolean g2Flip = false;
	private static boolean b2Flip = false;

	public static String loadFile(String path) {
		StringBuilder builder = new StringBuilder();

		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			String line;

			while ((line = br.readLine()) != null)
				builder.append(line + "\n");

			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}// End try-catch

		return builder.toString();
	}// End loadFile

	public static String[] loadFile(String path, String ignore) {
		String[] sections = { "", "", "" };

		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			String line;
			int index = -1;

			while ((line = br.readLine()) != null) {
				if (line.substring(0, 1).equals(ignore)) {
					index++;
					line = br.readLine();
				}// End if

				sections[index] += (line + " ");

			}// End while

			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}// End try-catch

		return sections;
	}// End loadFile

	public static ArrayList<String> loadFileArray(String path) {
		ArrayList<String> text = new ArrayList<String>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			String line;

			while ((line = br.readLine()) != null)
				text.add(line);

			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}// End try-catch

		return text;
	}// End loadFile

	public static int parseInt(String number) {
		try {
			return Integer.parseInt(number);
		} catch (NumberFormatException e) {
			System.out.println(number);
			Utilities.pauseGame(5000);
			e.printStackTrace();
			return 0;
		}// End try-catch
	}// End parseInt method

	public static int diceRoll() {
		return (int) (Math.random() * 5 + 1);
	}// End diceRoll method

	public static int genRandomNum(int seed) {
		return (int) (Math.random() * seed);
	}// End method genRandomNumber

	public static int genUniqueRandom(int range) {
		int rand = (int) (Math.random() * range);

		while (nums.contains(rand))
			rand = (int) (Math.random() * range);

		if (nums.size() == range - 1)
			nums.clear();

		nums.add(rand);
		return rand;
	}

	public static Color genRandomColor() {
		return new Color((int) (Math.random() * 256),
				(int) (Math.random() * 256), (int) (Math.random() * 256));
	}// End genRandonColor method

	public static void printArray(String[] data) {
		for (String d : data)
			System.out.println(d + "|");
	}// End printArray method

	public static void pauseGame(int duration) {
		try {
			Thread.sleep(duration);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}// End try catch
	}// End pauseGame method

	public static Color rainbowFade() {
		if (r2Flip)
			r2 -= 0.005f;
		else
			r2 += 0.005f;

		if (g2Flip)
			g2 -= 0.015f;
		else
			g2 += 0.015f;

		if (b2Flip)
			b2 -= 0.025f;
		else
			b2 += 0.025f;

		if (r2 > 0.95f)
			r2Flip = true;
		else if (r2 < 0.15f)
			r2Flip = false;

		if (g2 > 0.95f)
			g2Flip = true;
		else if (g2 < 0.15f)
			g2Flip = false;

		if (b2 > 0.95f)
			b2Flip = true;
		else if (b2 < 0.15f)
			b2Flip = false;

		return new Color(r2, g2, b2);
	}// End rainbowFade method

	public static Color hotlineFade() {
		if (rFlip)
			r -= 0.001f;
		else
			r += 0.001f;
		if (bFlip)
			b -= 0.005f;
		else
			b += 0.005f;

		if (r > 0.75f) {
			rFlip = true;
		} else if (r < 0.45f)
			rFlip = false;

		if (b > 0.95f)
			bFlip = true;
		else if (b < 0.65f)
			bFlip = false;

		return new Color(r, 0f, b);
	}// End hotlineFade method
}// End Utilities class
