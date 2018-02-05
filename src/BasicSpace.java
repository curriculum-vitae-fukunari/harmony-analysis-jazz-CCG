
public class BasicSpace {
	
	//メソッド内メソッド
	private static void Add(int mode[], int Vec[], int key){
		int temp[] = mode.clone();
		
		for(int i=0;i<12;i++){
			
			if(i == key){
				for(int j=0;j<temp.length;j++){
					temp[j] = temp[j]+i;
					if(temp[j] > 11){
						temp[j] = temp[j]-12;
					}
					Vec[temp[j]]++;
					
				}
			}
		}
			
	}
	
	 //コード構成音がスケール外の時
	private static void Check(int mode[], int Vec[], int Deg){
		int temp[] = mode.clone();
		
		for(int i=0;i<12;i++){
			
			if(i == Deg){
				
				
				for(int j=0;j<temp.length;j++){
					temp[j] = temp[j]+i;
					if(temp[j] > 11){
						temp[j] = temp[j]-12;
					}
					if(Vec[temp[j]] == 1){
						Vec[temp[j]]++;
					}
				}
			}
		}
		
		
		
	}
	
	//ここからメソッド
	public static int calcBasicSpaceDistance(int fromDeg , String fromKind, int fromKey , String fromMode , int toDeg , String toKind, int toKey , String toMode){
		
		int BasicSpaceDistance = 0;
		
		int fromkey  = 0;
		int	tokey    = 0;
		
		int fromVec[] = {0,0,0,0,0,0,0,0,0,0,0,0};
		int toVec[]   = {0,0,0,0,0,0,0,0,0,0,0,0};
		final int diatonic[] = {0,2,4,5,7,9,11};
		final int majorTriad[] = {0,4,7};
		final int minorTriad[] = {0,3,7};
		final int M7[] = {0,4,7,11};
		final int Mm7[] = {0,4,7,10};
		final int m7[] = {0,3,7,10};
		final int mM7[] = {0,3,7,11};
		final int mFlat5[] = {0,3,6};
		final int mFlat57[] = {0,3,6,10};
		final int dim7[] = {0,3,6,9};
		final int fifth[] = {0,7};
		
		
		//平行調の処理
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
				
		
		
		//スケール内Level.e
		if(fromMode == "M" || fromMode == "m"){
			Add(diatonic, fromVec, fromkey);
			}
		if(toMode == "M" || toMode == "m"){
			Add(diatonic, toVec, tokey);
			}
		
		
		//コード構成音Level.d
		//構成音がスケール外の音のとき抜け音を足す
		if(fromKind == "M"){
			Add(majorTriad, fromVec, fromDeg);
			Check(majorTriad, fromVec, fromDeg);
			}
		if(toKind == "M"){
			Add(majorTriad, toVec, toDeg);
			Check(majorTriad, toVec, toDeg);
		}
		if(fromKind == "m"){
			Add(minorTriad, fromVec, fromDeg);
			Check(minorTriad, fromVec, fromDeg);
			}
		if(toKind == "m"){
			Add(minorTriad, toVec, toDeg);
			Check(minorTriad, toVec, toDeg);
		}
		if(fromKind == "M7"){
			Add(M7, fromVec, fromDeg);
			Check(M7, fromVec, fromDeg);
			}
		if(toKind == "M7"){
			Add(M7, toVec, toDeg);
			Check(M7, toVec, toDeg);
		}
		if(fromKind == "Mm7"){
			Add(Mm7, fromVec, fromDeg);
			Check(Mm7, fromVec, fromDeg);
			}
		if(toKind == "Mm7"){
			Add(Mm7, toVec, toDeg);
			Check(Mm7, toVec, toDeg);
		}
		if(fromKind == "m7"){
			Add(m7, fromVec, fromDeg);
			Check(m7, fromVec, fromDeg);
			}
		if(toKind == "m7"){
			Add(m7, toVec, toDeg);
			Check(m7, toVec, toDeg);
		}
		if(fromKind == "mM7"){
			Add(mM7, fromVec, fromDeg);
			Check(mM7, fromVec, fromDeg);
			}
		if(toKind == "mM7"){
			Add(mM7, toVec, toDeg);
			Check(mM7, toVec, toDeg);
		}
		if(fromKind == "mFlat5"){
			Add(mFlat5, fromVec, fromDeg);
			Check(mFlat5, fromVec, fromDeg);
			}
		if(toKind == "mFlat5"){
			Add(mFlat5, toVec, toDeg);
			Check(mFlat5, toVec, toDeg);
		}
		if(fromKind == "mFlat57"){
			Add(mFlat57, fromVec, fromDeg);
			Check(mFlat57, fromVec, fromDeg);
			}
		if(toKind == "mFlat57"){
			Add(mFlat57, toVec, toDeg);
			Check(mFlat57, toVec, toDeg);
		}
		if(fromKind == "dim7"){
			Add(dim7, fromVec, fromDeg);
			Check(dim7, fromVec, fromDeg);
			}
		if(toKind == "dim7"){
			Add(dim7, toVec, toDeg);
			Check(dim7, toVec, toDeg);
		}
		
		
		
		//セブンスとかまだまだ続く
		
		//トライアドLevel.c
		if(fromKind == "M" || fromKind == "M7" || fromKind == "Mm7"){
			Add(majorTriad, fromVec, fromDeg);
			}
		if(toKind == "M" || toKind == "M7" || toKind == "Mm7"){
			Add(majorTriad, toVec, toDeg);
		}
		if(fromKind == "m" || fromKind == "m7" || fromKind == "mM7"){
			Add(minorTriad, fromVec, fromDeg);
			}
		if(toKind == "m" || toKind == "m7" || toKind == "mM7"){
			Add(minorTriad, toVec, toDeg);
		}
		if(fromKind == "mFlat5" || fromKind == "mFlat57" || fromKind == "dim7"){
			Add(mFlat5, fromVec, fromDeg);
			}
		if(toKind == "mFlat5" || toKind == "mFlat57" || toKind == "dim7"){
			Add(mFlat5, toVec, toDeg);
		}
		
		
		//fifth Level.b
		Add(fifth, fromVec, fromDeg);
		Add(fifth, toVec, toDeg);
		
		
		//root Level.a
		for(int i=0;i<12;i++){
			if(i == fromDeg){
				fromVec[i]++;
			}
			if(i == toDeg){
				toVec[i]++;
			}
		}
		
		
		//ベーシックスペース距離を求める
		for(int i=0;i<12;i++){
			if(toVec[i]>fromVec[i]){
				BasicSpaceDistance = BasicSpaceDistance+(toVec[i]-fromVec[i]);
			}
		}
	
		return BasicSpaceDistance;
	}

}
