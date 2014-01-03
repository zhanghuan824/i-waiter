package com.paipai.server.domain.table;

public class TableCategoryStrategy {

	public int PeerCount = 2;
	public int SmallCount = 4;
	public int MediumCount = 6;
	public int LargeCount = 10;
	
	public TableCategoryStrategy(int peerCount, int smallCount, int mediumCount, int largeCount) {
		this.PeerCount = peerCount;
		this.SmallCount = smallCount;
		this.MediumCount = mediumCount;
		this.LargeCount = largeCount;
	}
	
	public TableCategory getTableCategory(int amount) {
		if(this.LargeCount != -1 && amount > this.LargeCount)
			return TableCategory.Huge;
		else if(this.MediumCount != -1 && amount > this.MediumCount)
			return TableCategory.Large;
		else if(this.SmallCount != -1 && amount > this.SmallCount)
			return TableCategory.Medium;
		else if(this.PeerCount != -1 && amount > this.PeerCount)
			return TableCategory.Small;
		else return TableCategory.Peer;
	}
}
