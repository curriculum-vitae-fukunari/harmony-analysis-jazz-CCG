
public class AnalyzeTPS {
	
	//�R�[�h�l�[���̓��͕�
	static String ChordName[][]=
		{
			
		/*
		//1
		{ "4", "m7" },
		{ "9", "Mm7" },
		{ "2", "m7" },
		{ "7", "Mm7" },
		{ "0", "M" },
		{ "7", "m7" },
		{ "0", "Mm7" },
		{ "5", "M" },
		*/
		
		/*
		//2
		{ "7", "M" },
		{ "0", "M" },
		{ "2", "Mm7" },
		{ "7", "M" },
		{ "9", "Mm7" },
		{ "2", "M" },
		*/
		
		/*
		//3
		{ "11", "M7" },
		{ "10", "Mm7" },
		{ "3", "M7" },
		{ "11", "M7" },
		{ "10", "Mm7" },
		{ "3", "M7" },
		{ "9", "mFlat57" },
		{ "8", "m7" },
		{ "7", "m7" },
		//{ "6", "dim7" },
		{ "5", "m7" },
		{ "10", "Mm7" },
		{ "3", "M7" },
		/*
		
		/*
		//4
		{ "4", "m7" },
		{ "9", "Mm7" },
		{ "2", "m7" },
		{ "1", "Mm7" },
		{ "0", "M" },
		{ "2", "m7" },
		{ "7", "Mm7" },
		{ "0", "M" },
		*/
		
		/*
		//5
		{ "9", "mFlat57" },
		{ "2", "Mm7" },
		{ "7", "m" },
		{ "9", "mFlat57" },
		{ "2", "Mm7" },
		{ "7", "m" },
		*/
		
		
		//6
		{ "0", "m7" },
		{ "5", "Mm7" },
		{ "10", "M7" },
		{ "3", "M7" },
		{ "9", "mFlat57" },
		{ "2", "Mm7" },
		{ "7", "m" },
		
		
		/*
		//7
		{ "5", "M7" },
		{ "10", "M" },
		{ "0", "Mm7" },
		{ "5", "M7" },
		{ "4", "mFlat57" },
		{ "9", "Mm7" },
		{ "2", "m7" },
		{ "11", "mFlat57" },
		{ "4", "Mm7" },
		{ "9", "M7" },
		{ "7", "m7" },
		{ "0", "Mm7" },
		{ "5", "M" },
		*/
		
		/*
		//8
		{ "2", "M" },
		{ "6", "m7" },
		{ "7", "M7" },
		{ "7", "m7" },
		{ "0", "Mm7" },
		{ "5", "M7" },
		{ "4", "m7" },
		{ "9", "Mm7" },
		{ "2", "m" },
		{ "0", "m7" },
		*/
		
		};
	
	//�o�͕�
	static String ChordOutput[][] = new String[ChordName.length][4];
	
	
	public static void analyzeTPS(){
				
		//�m�[�h�����A�i�[
				String[][][] ChordNode = new String[ChordName.length][24][6];
				
				for(int i=0;i<ChordName.length;i++){
					for(int j=0;j<24;j++){
						ChordNode[i][j][0] = ChordName[i][0];
						ChordNode[i][j][1] = ChordName[i][1];
						
						if(j<12){
							ChordNode[i][j][2] = ""+j;
							ChordNode[i][j][3] = "M";
						}
						else{
							ChordNode[i][j][2] = (j-12)+"";
							ChordNode[i][j][3] = "m";
						}
						
						ChordNode[i][j][4] = "0";//���̃m�[�h�ɓ��B����܂ł̍ŒZ����
						ChordNode[i][j][5] = "No";//"No"�̓p�X���O�̃m�[�h����ʂ��Ă��Ă��Ȃ��Ƃ������ƁD�p�X���ʂ��Ă���Ȃ炻�̔ԍ�������D
						
					}
				}
				
			
				
				for(int i=0;i<ChordNode.length-1;i++){
					for(int j=0;j<24;j++){
						for(int k=0;k<24;k++){
							int d = TonalPitchSpace.calcTonalPitchSpace(Integer.parseInt(ChordNode[i][k][0]), ChordNode[i][k][1], Integer.parseInt(ChordNode[i][k][2]), ChordNode[i][k][3], 
																Integer.parseInt(ChordNode[i+1][j][0]), ChordNode[i+1][j][1], Integer.parseInt(ChordNode[i+1][j][2]), ChordNode[i+1][j][3]);
							
							if((Integer.parseInt(ChordNode[i][k][4]) + d) < Integer.parseInt(ChordNode[i+1][j][4]) || Integer.parseInt(ChordNode[i+1][j][4])== 0 ){
								ChordNode[i+1][j][4] = (Integer.parseInt(ChordNode[i][k][4]) + d)+"";//�ŒZ�����̍X�V
								ChordNode[i+1][j][5] = k+"";//�p�X���ʂ��Ă���Ȃ炻�̔ԍ�������D
							}
							
						}
					}
				}
				
				int distance = 0;
				int path = 0;
				
				for(int i=ChordNode.length-1; i>-1; i--){
					
					//�ŏI�m�[�h�݂̂̏���
					if(i==ChordNode.length-1){
						for(int j=0; j<24; j++){
							if(Integer.parseInt(ChordNode[i][j][4]) < distance ||distance==0 ){
								distance = Integer.parseInt(ChordNode[i][j][4]);
								path = j;
							}		
						}
						
						//�A�E�g�v�b�g�Ɋi�[
						ChordOutput[i][0] = ChordNode[i][path][0];
						ChordOutput[i][1] = ChordNode[i][path][1];
						ChordOutput[i][2] = ChordNode[i][path][2];
						ChordOutput[i][3] = ChordNode[i][path][3];
						
						//path�̍X�V
						path = Integer.parseInt(ChordNode[i][path][5]);
					}
					//�ŏ��̃m�[�h�݂̂̏���
					else if(i == 0){
						//�A�E�g�v�b�g�Ɋi�[
						ChordOutput[i][0] = ChordNode[i][path][0];
						ChordOutput[i][1] = ChordNode[i][path][1];
						ChordOutput[i][2] = ChordNode[i][path][2];
						ChordOutput[i][3] = ChordNode[i][path][3];
					}
					//����ȊO�̃m�[�h�Ɋւ���
					else{
						//�A�E�g�v�b�g�Ɋi�[
						ChordOutput[i][0] = ChordNode[i][path][0];
						ChordOutput[i][1] = ChordNode[i][path][1];
						ChordOutput[i][2] = ChordNode[i][path][2];
						ChordOutput[i][3] = ChordNode[i][path][3];
					
						//path�̍X�V
						path = Integer.parseInt(ChordNode[i][path][5]);
					}
						
				}
		
		return;
		
	}
	

	
}