package org.yeremy;

import java.util.ArrayList;
import java.util.Stack;

public class StackBasedWumpusHunter extends WumpusHunter {

	public StackBasedWumpusHunter() {

	}

	@Override
	public String getName() {
		return "Yeremy the Wumpus Hunter";
	}

	@Override
	public void startAt(MountainCave root) {
		Stack<MountainCave> stack = new Stack<MountainCave>();
		Stack<MountainCave> pathStack = new Stack<MountainCave>();

		stack.push(root);

		while (!stack.isEmpty()) {
			MountainCave currentCave = stack.pop();

			this.actionLog = this.actionLog + "Entering the " + currentCave.getCaveName() + "\n";

			if (currentCave.hasScales()) {
				this.actionLog = this.actionLog + "We've found the scales!" + "\n";


				// Filling the pathStack
				while(currentCave.getParent() != null) {
					pathStack.push(currentCave);
					currentCave = currentCave.getParent();
				}


				//Adding path to the actionLog
				this.actionLog = this.actionLog + "...The path is..." + "\n";
				this.actionLog = this.actionLog + "Start at the Mountain Top" + "\n";
				while(!pathStack.isEmpty()) {
					this.actionLog = this.actionLog + "And then visit the " + pathStack.pop().getCaveName() + "\n";
				}

				return;
			}


			if (currentCave.isAdjacentToScales())
				this.actionLog = this.actionLog + "We've neared the scales!" + "\n";



			ArrayList<MountainCave> caveList = currentCave.getChildren();

			// Adding children to the stack
			for (MountainCave child: caveList) {
				if (child != null) stack.push(child);
			}

		}// end of while loop



	}// end of method

}
