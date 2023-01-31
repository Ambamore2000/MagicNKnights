package project;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import acm.graphics.GImage;
import acm.graphics.GLabel;
import acm.graphics.GLine;
import acm.graphics.GObject;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;
import project.cards.LargeHealthPotion;
import project.cards.LargeManaPotion;
import project.cards.LifeSteal;
import project.cards.ManaRevive;
import project.cards.Revive;
import project.cards.Slash;
import project.cards.SmallHealthPotion;
import project.cards.SmallManaPotion;
import project.cards.SoulSteal;
import project.cards.Split;
import project.cards.Stab;
import project.cards.Stick;
import project.cards.Suicide;
import starter.GraphicsPane;

public class MapGraphics extends GraphicsPane {

	private MainMenu program;
	
	private GImage background;
	private Level levelOne;
	private Level levelTwo;
	private Level levelThree;
	private Level levelFour;
	private Level levelFive;
	private Level levelSix;
	private Level levelSeven;
	private Level levelEight;
	private Level levelNine;
	private Level levelTen;
	private Level levelEleven;
	private Level levelTwelve;
	private Level levelThirteen;
	private Level levelFourteen;
	private Level levelFifteen;
	private Level levelSixteen;
	private Level levelSeventeen;
	private Level levelEighteen;
	private Level levelNineteen;
	private Level levelTwenty;
	
	private ArrayList<Level> levelList1;
	private ArrayList<Level> levelList2;
	private GImage levelHovered;
	
	public MapGraphics(MainMenu program) {
		super();
		this.program = program;
		try {
			initializeObjects();
		} catch (ParseException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private Card getCardFromString(String cardString) {
		switch (cardString) {
			case "stick": return new Stick();
			case "smallmanapotion": return new SmallManaPotion(); 
			case "slash": return new Slash();
			case "smallhealthpotion": return new SmallHealthPotion();
			case "split": return new Split();
			case "largemanapotion": return new LargeManaPotion();
			case "largehealthpotion": return new LargeHealthPotion();
			case "lifesteal": return new LifeSteal();
			case "stab": return new Stab();
			case "manarevive": return new ManaRevive();
			case "revive": return new Revive();
			case "soulsteal": return new SoulSteal();
			case "suicide": return new Suicide();
		}
		return null;
	}
	
	private void initializeObjects() throws ParseException, FileNotFoundException, IOException {
		background = new GImage("media/images/Background.png", 0, 0);
		background.setSize(MainMenu.RESOLUTION_X, MainMenu.RESOLUTION_Y);
		
		levelList1 = new ArrayList<>();
		levelList2 = new ArrayList<>();
		
		// Added to test levelList
		
		ArrayList<Level> levelListTest = new ArrayList<>();
		
		//TODO: Pseudocode for dynamic loading of levels
		// Using https://www.geeksforgeeks.org/parse-json-java/ as reference
		
		
		//Parse JSON File to read all levels information
		
		JSONObject jsonObj = (JSONObject) new JSONParser().parse(new FileReader("project/levels.json"));
		
		System.out.println(jsonObj.toJSONString());
		System.out.println("Start iteration");
		//Iterate through each level
        
		JSONArray levelsArray = (JSONArray) jsonObj.get("levels");
		System.out.println("Levels Array:");
	    System.out.println(levelsArray);

	    Iterator levelsArrayIter = levelsArray.iterator();

	    while (levelsArrayIter.hasNext()) {
	    	JSONObject levelObject = (JSONObject) levelsArrayIter.next();

	    	System.out.println("levelObject:");
	    	System.out.println(levelObject);
			
			JSONArray levelArray = (JSONArray) levelObject.get(String.valueOf(levelObject.keySet().toArray()[0]));
			System.out.println("levelArray:");
			System.out.println(levelArray);
	        
			Iterator levelArrayIter = levelArray.iterator();

		    while (levelArrayIter.hasNext()) {
		    	JSONObject levelEntry = (JSONObject) levelArrayIter.next();
		    	
				System.out.println("levelEntry:");
				System.out.println(levelEntry);
				
				System.out.println("INFORMATION");
				
				//Load level image source, x, and y position
				String levelImageSource;
				int x, y;
				JSONObject levelImageObject = (JSONObject) levelEntry.get("level_image");
				
				System.out.println("levelImageObject:");
				System.out.println(levelImageObject);
				
				levelImageSource = (String) levelImageObject.get("src");
				System.out.println("levelImageSource:");
				System.out.println(levelImageSource);
				
				x = ((Long) levelImageObject.get("x")).intValue();
				System.out.println("x:");
				System.out.println(x);
				
				y = ((Long) levelImageObject.get("y")).intValue();
				System.out.println("y:");
				System.out.println(y);
				
				//Load level number
				int levelNumber = ((Long) levelEntry.get("level")).intValue();
				System.out.println("levelNumber:");
				System.out.println(levelNumber);
				
				//Iterate through enemy
				JSONObject enemyObject = (JSONObject) levelEntry.get("enemy");
				
				//  Load enemy name
				String enemyName = (String) enemyObject.get("name");
				System.out.println("enemyName:");
				System.out.println(enemyName);
				
				//  Load enemy image source
				String enemyImageSource = (String) enemyObject.get("image");
				System.out.println("enemyImageSource:");
				System.out.println(enemyImageSource);
				
				//  Load enemy hp, max hp, mana, max mana
				int enemyHp = ((Long) enemyObject.get("hp")).intValue();
				System.out.println("enemyHp:");
				System.out.println(enemyHp);
				
				int enemyMaxHp = ((Long) enemyObject.get("maxHp")).intValue();
				System.out.println("enemyMaxHp:");
				System.out.println(enemyMaxHp);
				
				int enemyMana = ((Long) enemyObject.get("mana")).intValue();
				System.out.println("enemyMana:");
				System.out.println(enemyMana);
				
				int enemyMaxMana = ((Long) enemyObject.get("maxMana")).intValue();
				System.out.println("enemyMaxMana:");
				System.out.println(enemyMaxMana);
				
				//  Iterate through enemy deck
				JSONObject enemyDeckObject = ((JSONObject)levelEntry.get("enemy"));
				JSONArray enemyDeckArray = (JSONArray) enemyDeckObject.get("deck");

				//    Load each card into deck
				ArrayList<Card> enemyDeck = new ArrayList<Card>();
				
				System.out.println("--cards:");
				Iterator enemyDeckArrayIter = enemyDeckArray.iterator();
				while (enemyDeckArrayIter.hasNext()) {
					String enemyCardString = (String) enemyDeckArrayIter.next();
					System.out.println(enemyCardString);
					enemyDeck.add(getCardFromString(enemyCardString));
				}
				System.out.println("--");
				
				//Load level completed
				boolean levelCompleted = (boolean) levelEntry.get("completed");
				System.out.println("levelCompleted:");
				System.out.println(levelCompleted);
				
				//Iterate through reward
				String rewardCardString;
				int gold;
				JSONObject rewardObject = (JSONObject) levelEntry.get("reward");
				
				System.out.println("rewardObject:");
				System.out.println(rewardObject);

				//  Load gold reward
				gold = ((Long) rewardObject.get("gold")).intValue();
				System.out.println("gold:");
				System.out.println(gold);
				
				//  Load card reward
				rewardCardString = (String) rewardObject.get("card");
				System.out.println("rewardCardString:");
				System.out.println(rewardCardString);
				
				Reward rewardToAdd;
				if (rewardCardString == null) {
		            rewardToAdd = new Reward(program.getPlayer(), gold, null);
				} else {
		            rewardToAdd = new Reward(program.getPlayer(), gold, getCardFromString(rewardCardString));
				}

	            System.out.println("--------------------------------");
	            //TODO Enemy deck and reward card
	            Enemy enemyToAdd = new Enemy(enemyName, new GImage(enemyImageSource), enemyHp, enemyMaxHp, enemyMana, enemyMaxMana, enemyDeck);
	            Level levelToAdd = new Level(new GImage(levelImageSource, x * 300, y * 200), levelNumber, enemyToAdd, false, rewardToAdd);
	            
	            if (levelToAdd.getLevelNumber() > 10) {
	        		levelList2.add(levelToAdd);
	            } else {
	            	levelList1.add(levelToAdd);
	            }
		    }
	    }
		
		loadLevels();
	}
	
	public void loadLevels() {
		int currLevel = Integer.parseInt(ConfigManager.getPath("level"));
		
		for (Level level : levelList1) {
			level.getLevelImage().setSize(150, 150);
			level.getLevelImage().setVisible(false);
		}
		for (Level level : levelList2) {
			level.getLevelImage().setSize(150, 150);
			level.getLevelImage().setVisible(false);
		}
		
		if (currLevel > 10) {
			for (Level level : levelList2) {
				if (level.getLevelNumber() >= currLevel) {
					level.getLevelImage().setVisible(true);
				}
			}
		} else {
			for (Level level : levelList1) {
				if (level.getLevelNumber() >= currLevel) {
					level.getLevelImage().setVisible(true);
				}
			}
		}
		
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		GObject currElem = program.getElementAt(e.getX(), e.getY());
		if (currElem instanceof GImage) {
			for (Level level : levelList1) {
				if (level.getLevelImage() == currElem && Integer.parseInt(ConfigManager.getPath("level")) == level.getLevelNumber()) {
					if (!checkIfDeckEmpty())
						program.openBoard(level);
				}
			}
			for (Level level : levelList2) {
				if (level.getLevelImage() == currElem && Integer.parseInt(ConfigManager.getPath("level")) == level.getLevelNumber()) {
					if (!checkIfDeckEmpty())
						program.openBoard(level);
				}
			}
			if (currElem == MainMenuGraphics.menuButton) {
				program.openMainMenu();
			}
		}
	}
	
	//todo fix
	private boolean checkIfDeckEmpty() {
		if (program.getPlayer().getDeck().isEmpty()) {
			new Thread() {
				public void run() {
					
					GLabel emptyLabel = new GLabel("DECK IS EMPTY");
					emptyLabel.setFont(new Font("TimesRoman", Font.PLAIN, 50));
					
					emptyLabel.setLocation(1920/2 - 75, 1080/2 - 25);
					
					program.add(emptyLabel);
					
					for (int x = 0; x < 30; x++) {
						emptyLabel.move(0, 10);
						program.pause(100);
					}
					
					program.remove(emptyLabel);
				}
			}.start();
			return true;
		}
		return false;
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		GObject currElem = program.getElementAt(e.getX(), e.getY());
		
		if (currElem instanceof GImage) {
			for (Level level : levelList1) {
				if (level.getLevelImage() == currElem) {
					levelHovered = level.getLevelImage();
					levelHovered.setSize(140, 140);
					return;
				}
			}
			for (Level level : levelList2) {
				if (level.getLevelImage() == currElem) {
					levelHovered = level.getLevelImage();
					levelHovered.setSize(140, 140);
					return;
				}
			}
		}
		
		if (levelHovered != null) {
			levelHovered.setSize(150, 150);
			levelHovered = null;
		}
		
	}
	 
	@Override
	public void showContents() {
		program.add(background);

		for (Level level : levelList1) {
			program.add(level.getLevelImage());
		}
		for (Level level : levelList2) {
			program.add(level.getLevelImage());
		}

		program.add(MainMenuGraphics.menuButton);
	}
	
	@Override
	public void hideContents() {
		program.remove(background);

		for (Level level : levelList1) {
			program.remove(level.getLevelImage());
		}
		for (Level level : levelList2) {
			program.remove(level.getLevelImage());
		}
		
		program.remove(MainMenuGraphics.menuButton);
	}
}
