
public class Region {
	
	public static int calcRegionDistance(int fromKey , String fromMode , int toKey , String toMode){
		
		int regiondistance = 0;
		
		int fromkey = 0;
		int	tokey   = 0;
		
		
		//ïΩçsí≤ÇÃèàóù
		for(int i=0;i<12;i++){
			int j = i+9;
			if(j>11){
				j = j -12;
			}
			if( (fromKey == i && fromMode == "M") || (fromKey == j && fromMode == "m") || (fromKey == j && fromMode == "hm") ){
				fromkey = i;
			}
			if( (toKey == i && toMode == "M") || (toKey == j && toMode == "m") || (toKey == j && fromMode == "hm") ){
				tokey = i;
			}
		}
		
		
		
		if(fromkey - tokey ==0){
			regiondistance = 0;
		}
		else if(fromkey - tokey ==7||fromkey - tokey ==-7||fromkey - tokey ==5||fromkey - tokey ==-5){
			regiondistance = 1;
		}
		else if(fromkey - tokey ==2||fromkey - tokey ==-2||fromkey - tokey ==10||fromkey - tokey ==-10){
			regiondistance = 2;
		}
		else if(fromkey - tokey ==9||fromkey - tokey ==-9||fromkey - tokey ==3||fromkey - tokey ==-3){
			regiondistance = 3;
		}
		else if(fromkey - tokey ==4||fromkey - tokey ==-4||fromkey - tokey ==8||fromkey - tokey ==-8){
			regiondistance = 4;
		}
		else if(fromkey - tokey ==11||fromkey - tokey ==-11||fromkey - tokey ==1||fromkey - tokey ==-1){
			regiondistance = 5;
		}
		else if(fromkey - tokey ==6||fromkey - tokey ==-6){
			regiondistance = 6;
		}
		else{
			regiondistance = 99;
		}
		
		/*
		//ïΩçsí≤ä‘Ç…Ç®ÇØÇÈí≤ä‘ãóó£Ç0.5Ç…ê›íË
		if(!fromMode.equals(toMode)){
			regiondistance = regiondistance+0.5;
		}
		*/
		
		
		return regiondistance;
		
	}

}
