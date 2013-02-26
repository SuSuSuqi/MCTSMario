package itu.ejuuragr;

import competition.cig.robinbaumgarten.astar.LevelScene;
import competition.cig.robinbaumgarten.astar.sprites.Mario;

import itu.ejuuragr.UTC.UTCNode;

public class MCTSTools {

	//                                      {LEFT, RIGHT, DOWN, JUMP, SPEED}
	public static final boolean[] buttons = {false, true, false, true, true};
	

	public static void main(String[] args)
	{
		boolean[] test1 = {false,true,false,false,true};
		int idx = actionToIndex(test1);
		boolean[] out = indexToAction(idx);
		System.out.println(idx);
		System.out.println(possibleActionsCount());
		for (int i = 0; i < out.length; i++)
			System.out.print(out[i] + " ");
		System.out.println();
	}
	
	
	
	public static int possibleActionsCount()
	{
		int acts = 1;
		for (int i = 0; i < 5; i++)
			if (buttons[i])
				acts <<= 1;
		return acts;
	}
	
	public static int actionToIndex(boolean[] action)
	{
		int index = 0;
		int j = 0;
		for (int i = 0; i < 5; i++)
		{
			if (!buttons[i]) continue;
			if (action[i])
				index += 1<<j;
			j++;
		}
		
		return index;
	}
	
	public static boolean[] indexToAction(int index)
	{
		boolean[] action = new boolean[5];
		
		int j = 0;
		for (int i = 0; i < 5; i++)
		{
			if (!buttons[i]) continue;
			action[i] = ((index & 1<<j) != 0);
			j++;
		}
		
		return action;
	}
	
	public static LevelScene advanceStepClone(LevelScene state, boolean[] action){
		try {
			
			LevelScene result = (LevelScene) state.clone();
			result.mario.setKeys(action);
			result.tick();
			return result;
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return null;
	}	
	
	public static double marioShrunk(Mario old, Mario cur){
		int before = marioSize(old);
		int after = marioSize(cur);
		if(after < before) return 2.0;
		if(after > before) return 1/2.0;
		return 1.0;
	}
	
	public static int marioSize(Mario mario){
		if(mario.fire) return 2;
		if(mario.large) return 1;
		return 0;
	}
	
	/********************
	 * XML Stuff
	 ********************/
	
	public static String actionToXML(boolean[] act)
	{
		StringBuilder b = new StringBuilder("Move=\"");
		if (act == null || act.length < 5)
			b.append("Nothing");
		else
		{
			if (act[0]) b.append("Left ");
			if (act[1]) b.append("Right ");
			if (act[2]) b.append("Down ");
			if (act[3]) b.append("Jump ");
			if (act[4]) b.append("Speed ");
			if (!(act[0] || act[1] || act[2] || act[3] || act[4])) b.append("Nothing");
		}
		return b.append("\"").toString();
	}
	
	public static String getXMLRepresentation(UTCNode n)
	{
		StringBuilder b = new StringBuilder();
		getXMLRepresentation(n, b);
		return b.toString();
	}
	
	private static void getXMLRepresentation(UTCNode n, StringBuilder b)
	{
		b.append("<Node " + actionToXML(n.action) + " " + String.format("Reward=\"%s\"",n.reward/n.visited) + ">");
		if (n.children != null)
			for (UTCNode c : n.children)
				if (c != null)
					getXMLRepresentation(c,b);		
		b.append("</Node>");
	}
	
	
}
